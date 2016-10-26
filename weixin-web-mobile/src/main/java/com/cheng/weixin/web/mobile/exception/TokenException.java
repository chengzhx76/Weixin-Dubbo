package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.StatusCode;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/24
 */
public class TokenException extends BaseException {
    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(StatusCode statusCode) {
        super(statusCode);
    }
    public TokenException(StatusCode statusCode, String message) {
        super(statusCode, message);
    }
    public TokenException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    protected StatusCode getStatusCode() {
        return super.statusCode != null ? super.statusCode : StatusCode.UNAUTHORIZED;
    }
}
