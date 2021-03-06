/*
 * (C) Copyright 2016 Ymatou (http://www.ymatou.com/). All rights reserved.
 */
package com.ymatou.payment.facade.model;

import com.ymatou.payment.facade.PrintFriendliness;

/**
 * 交易信息
 * 
 * @author qianmin 2016年5月11日 下午3:00:31
 * 
 */
public class TradeDetail extends PrintFriendliness {

    private static final long serialVersionUID = -1996785311799086155L;

    /**
     * 交易号
     */
    private String tradeNo;
    /**
     * 交易类型
     */
    private int tradeType;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }
}
