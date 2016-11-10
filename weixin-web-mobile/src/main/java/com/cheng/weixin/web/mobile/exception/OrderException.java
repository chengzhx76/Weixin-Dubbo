package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.StatusCode;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/10
 */
public class OrderException extends BusinessException{
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }


    public OrderException(StatusCode statusCode) {
        super(statusCode);
    }
    public OrderException(StatusCode statusCode, String message) {
        super(statusCode, message);
    }

    public OrderException(String message, Exception e) {
        super(message, e);
    }


    @Override
    protected StatusCode getStatusCode() {
        return super.statusCode != null ? super.statusCode : StatusCode.COUPON_EXCEPTION;
    }
}
