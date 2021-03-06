/**
 * (C) Copyright 2016 Ymatou (http://www.ymatou.com/).
 *
 * All rights reserved.
 */
package com.ymatou.payment.domain.channel.service.acquireorder;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymatou.payment.domain.channel.InstitutionConfig;
import com.ymatou.payment.domain.channel.InstitutionConfigManager;
import com.ymatou.payment.domain.channel.constants.AliPayConsts;
import com.ymatou.payment.domain.channel.model.AcquireOrderPackageResp;
import com.ymatou.payment.domain.channel.service.AcquireOrderService;
import com.ymatou.payment.domain.channel.service.SignatureService;
import com.ymatou.payment.domain.channel.util.AliPayFormBuilder;
import com.ymatou.payment.domain.pay.model.Payment;
import com.ymatou.payment.facade.BizException;
import com.ymatou.payment.facade.ErrorCode;
import com.ymatou.payment.facade.constants.AcquireOrderResultTypeEnum;
import com.ymatou.payment.facade.model.AcquireOrderExt;
import com.ymatou.payment.integration.IntegrationConfig;
import com.ymatou.payment.integration.model.QueryTimestampResponse;
import com.ymatou.payment.integration.service.alipay.QueryTimestampService;

/**
 * AliPay PC 收单报文组织（10）
 * 
 * @author wangxudong 2016年5月11日 下午5:22:24
 *
 */
@Component
public class AliPayPcAcquireOrderServiceImpl implements AcquireOrderService {

    private static Logger logger = LoggerFactory.getLogger(AliPayPcAcquireOrderServiceImpl.class);


    @Resource
    private InstitutionConfigManager instConfigManager;

    @Resource
    private IntegrationConfig integrationConfig;

    @Resource
    private QueryTimestampService queryTimestampService;

    @Resource
    private SignatureService signatureService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ymatou.payment.domain.channel.service.AcquireOrderService#AcquireOrder(com.ymatou.payment
     * .domain.pay.model.Payment)
     */
    @Override
    public AcquireOrderPackageResp acquireOrderPackage(Payment payment, HashMap<String, String> mockHeader) {
        // 获取第三方机构配置
        InstitutionConfig instConfig = instConfigManager.getConfig(payment.getPayType());

        // 拼装请求Map
        HashMap<String, String> reqMap = buildReqMap(payment, instConfig, mockHeader);

        // 签名
        String sign = signatureService.signMessage(reqMap, instConfig, mockHeader);
        reqMap.put("sign", sign);

        // 拼装请求报文
        String reqForm = AliPayFormBuilder.buildForm(reqMap, integrationConfig.getAliPayBaseUrl(null));

        // 返回报文结果
        AcquireOrderPackageResp resp = new AcquireOrderPackageResp();
        resp.setResultType(AcquireOrderResultTypeEnum.Form);
        resp.setResult(reqForm);

        return resp;
    }

    /**
     * 构造请求字典
     * 
     * @param payment
     * @return
     */
    private HashMap<String, String> buildReqMap(Payment payment, InstitutionConfig instConfig,
            HashMap<String, String> mockHeader) {
        AcquireOrderExt acquireOrderExt = getExt(payment.getBussinessOrder().getExt());

        HashMap<String, String> reqDict = new HashMap<String, String>();
        reqDict.put("payment_type", AliPayConsts.PAYMENT_TYPE_PURCHARE);
        reqDict.put("partner", instConfig.getMerchantId());
        reqDict.put("seller_email", instConfig.getSellerEmail());
        reqDict.put("return_url",
                String.format("%s/callback/%s", integrationConfig.getYmtPaymentBaseUrl(),
                        payment.getPayType().getCode()));
        reqDict.put("notify_url",
                String.format("%s/notify/%s", integrationConfig.getYmtPaymentBaseUrl(),
                        payment.getPayType().getCode()));
        reqDict.put("_input_charset", AliPayConsts.INPUT_CHARSET);
        reqDict.put("show_url", payment.getBussinessOrder().getProductUrl());
        reqDict.put("out_trade_no", payment.getPaymentId());
        reqDict.put("subject", payment.getBussinessOrder().getSubject());
        reqDict.put("body", payment.getBussinessOrder().getProductDesc());
        reqDict.put("total_fee", String.format("%.2f", payment.getPayPrice().getAmount().doubleValue()));
        reqDict.put("paymethod", acquireOrderExt.getPayMethod());
        reqDict.put("anti_phishing_key", getAntiFishingKey(instConfig.getMerchantId(), mockHeader));
        reqDict.put("exter_invoke_ip", payment.getBussinessOrder().getClientIp());
        reqDict.put("buyer_email", payment.getBussinessOrder().getThirdPartyUserId());
        reqDict.put("sign_type", instConfig.getSignType());

        if (acquireOrderExt.getIsHangZhou() != null && acquireOrderExt.getIsHangZhou() == 1) {
            reqDict.put("service", "alipay.acquire.page.createandpay");
            reqDict.put("buyer_info", "{\"needBuyerRealnamed\":\"T\"}");
            reqDict.put("product_code", "FAST_INSTANT_TRADE_PAY");

            String showMode = acquireOrderExt.getShowMode();
            if (showMode != null && !showMode.isEmpty()) {
                reqDict.put("extend_parameters", String.format("{\"qrPayMode\":\"%s\"}", showMode));
            }
        } else {
            reqDict.put("service", "create_direct_pay_by_user");
            reqDict.put("defaultbank", payment.getBankId());

            String thirdPartyUserId = payment.getBussinessOrder().getThirdPartyUserId();
            if (thirdPartyUserId != null && !thirdPartyUserId.isEmpty())
                reqDict.put("default_login", "Y");
            else
                reqDict.put("default_login", "N");

            String showMode = acquireOrderExt.getShowMode();
            if (showMode != null && !showMode.isEmpty()) {
                reqDict.put("qr_pay_mode", showMode);
            }
        }

        return reqDict;
    }

    /**
     * 获取到防钓鱼参数
     * 
     * @param merchantId
     * @return
     */
    private String getAntiFishingKey(String merchantId, HashMap<String, String> mockHeader) {
        String antiFishKey = "";
        try {
            QueryTimestampResponse response = queryTimestampService.doService("query_timestamp", merchantId,
                    mockHeader);
            if (response != null)
                antiFishKey = response.getTimestampEncryptKey();
        } catch (Exception ex) {
            logger.error("get anti fishing key failed", ex);
        }

        if (antiFishKey.isEmpty())
            throw new BizException(ErrorCode.QUERY_ANTI_FISHING_KEY_FAILED, null);

        return antiFishKey;
    }


    /**
     * 获取到扩展参数
     * 
     * @param ext
     * @return
     */
    private AcquireOrderExt getExt(String extJson) {
        AcquireOrderExt acquireOrderExt = new AcquireOrderExt();
        if (extJson == null || extJson.isEmpty()) {
            acquireOrderExt.setShowMode("2");
            acquireOrderExt.setPayMethod("bankPay");
            acquireOrderExt.setIsHangZhou(0);
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                acquireOrderExt = objectMapper.readValue(extJson.toUpperCase(), AcquireOrderExt.class);

                String payMethod = acquireOrderExt.getPayMethod();
                if (payMethod == null)
                    payMethod = "2";

                payMethod = AliPayConsts.PAY_METHOD_MAP.getOrDefault(payMethod, "bankPay");
                acquireOrderExt.setPayMethod(payMethod);

            } catch (Exception ex) {
                logger.error("unrecognize ext param", ex);
                throw new BizException(ErrorCode.INVALID_EXT_MESSAGE, extJson, ex);
            }
        }

        return acquireOrderExt;
    }
}
