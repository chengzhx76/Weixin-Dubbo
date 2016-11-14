package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.StatusCode;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/14
 */
public class UserException extends BaseException {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }


    public UserException(StatusCode statusCode) {
        super(statusCode);
    }
    public UserException(StatusCode statusCode, String message) {
        super(statusCode, message);
    }

    public UserException(String message, Exception e) {
        super(message, e);
    }

    protected StatusCode getStatusCode() {
        return super.statusCode != null ? super.statusCode : StatusCode.USER_EXCEPTION;
    }
}
