package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.StatusCode;

/**
 * Desc: 商品
 * Author: hp
 * Date: 2016/10/26
 */
public class ProductException extends BaseException {

    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }


    public ProductException(StatusCode statusCode) {
        super(statusCode);
    }
    public ProductException(StatusCode statusCode, String message) {
        super(statusCode, message);
    }

    public ProductException(String message, Exception e) {
        super(message, e);
    }


    @Override
    protected StatusCode getStatusCode() {
        return super.statusCode != null ? super.statusCode : StatusCode.PRODUCT_EXCEPTION;
    }
}
