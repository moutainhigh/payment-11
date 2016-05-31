package com.ymatou.payment.facade.rest;

import java.util.Enumeration;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ymatou.payment.facade.PaymentFacade;
import com.ymatou.payment.facade.model.AcquireOrderReq;
import com.ymatou.payment.facade.model.AcquireOrderResp;

/**
 * 支付REST接口实现
 * 
 * @author wangxudong
 *
 */
@Path("/{api:(?i:api)}")
@Component("paymentResource")
@Produces({"application/json; charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class PaymentResourceImpl implements PaymentResource {

    /**
     * 支付接口
     */
    @Resource
    private PaymentFacade paymentFacade;

    /**
     * 支付收单
     */
    @Override
    @POST
    @Path("/{AcquireOrder:(?i:AcquireOrder)}")
    public AcquireOrderResp acquireOrder(AcquireOrderReq req, @Context HttpServletRequest servletRequest) {
        req.setMockHeader(getMockHttpHeader(servletRequest));

        String rawString = JSON.toJSONString(req);

        AcquireOrderResp resp = paymentFacade.acquireOrder(req);
        resp.setAppId(req.getAppId());
        resp.setTraceId(req.getTraceId());

        return resp;
    }

    /**
     * 获取请求中的HttpMockHeader
     * 
     * @param servletRequest
     * @return
     */
    private HashMap<String, String> getMockHttpHeader(HttpServletRequest servletRequest) {
        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        HashMap<String, String> header = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            if (headerName != null && headerName.toLowerCase().startsWith("mock"))
                header.put(headerName, servletRequest.getHeader(headerName));
        }
        return header;
    }

}
