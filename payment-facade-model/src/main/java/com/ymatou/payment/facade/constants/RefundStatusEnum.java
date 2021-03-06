/*
 * (C) Copyright 2016 Ymatou (http://www.ymatou.com/). All rights reserved.
 */
package com.ymatou.payment.facade.constants;

/**
 * 退款状态
 * 
 * @author qianmin 2016年5月10日 下午7:17:14
 * 
 */
public enum RefundStatusEnum {
    // 微信用户账户异常或已注销
    COMPLETE_FAILED_WX_USER_ABNORMAL(-3),

    COMPLETE_FAILED(-2),

    REFUND_FAILED(-1),

    INIT(0),

    COMMIT(1),

    WAIT_THIRDPART_REFUND(2),

    THIRDPART_REFUND_SUCCESS(3),

    COMPLETE_SUCCESS(4),

    RETURN_TRANSACTION(5),

    RETURN_BALANCE(6);

    private int code;

    private RefundStatusEnum(int code) {
        this.code = code;
    }



    public int getCode() {
        return code;
    }


    public static RefundStatusEnum withCode(int code) {
        switch (code) {
            case 0:
                return INIT;
            case 1:
                return COMMIT;
            case 2:
                return WAIT_THIRDPART_REFUND;
            case 3:
                return THIRDPART_REFUND_SUCCESS;
            case 4:
                return COMPLETE_SUCCESS;
            case 5:
                return RETURN_TRANSACTION;
            case 6:
                return RETURN_BALANCE;
            case -1:
                return REFUND_FAILED;
            case -2:
                return COMPLETE_FAILED;
            default:
                return INIT;
        }
    }
}
