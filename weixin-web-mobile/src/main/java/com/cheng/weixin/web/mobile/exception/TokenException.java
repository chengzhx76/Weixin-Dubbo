package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.HttpCode;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/24
 */
public class TokenException extends BaseException {

    public TokenException(String message, Throwable ex) {
        super(message, ex);
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException() {
        super();
    }

    @Override
    protected HttpCode getHttpCode() {
        return HttpCode.UNAUTHORIZED;
    }
}
