package com.cheng.weixin.web.mobile.exception;


import com.cheng.weixin.web.mobile.exception.message.StatusCode;

@SuppressWarnings("serial")
public class LoginException extends BaseException {
	public LoginException() {
	}

	public LoginException(String message) {
		super(message);
	}


	public LoginException(StatusCode statusCode) {
		super(statusCode);
	}
	public LoginException(StatusCode statusCode, String message) {
		super(statusCode, message);
	}

	public LoginException(String message, Exception e) {
		super(message, e);
	}


	protected StatusCode getStatusCode() {
		return super.statusCode != null ? super.statusCode : StatusCode.LOGIN_FAIL;
	}
}
