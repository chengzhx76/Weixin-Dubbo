package com.cheng.weixin.web.mobile.security;

/**
 * Desc: 令牌异常
 * Author: cheng
 * Date: 2016/6/21
 */
public class TokenException extends RuntimeException {

    public TokenException(String message) {
        super(message);
    }
}
