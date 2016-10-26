/**
 * 
 */
package com.cheng.weixin.web.mobile.exception;


import com.cheng.weixin.web.mobile.exception.message.StatusCode;

/**
 * Desc: 异常 - 参数异常
 * Author: cheng
 * Date: 2016/6/21
 */
@SuppressWarnings("serial")
public class IllegalParameterException extends BaseException {
	public IllegalParameterException() {
	}

	public IllegalParameterException(Throwable ex) {
		super(ex);
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(StatusCode statusCode) {
		super(statusCode);
	}
	public IllegalParameterException(StatusCode statusCode, String message) {
		super(statusCode, message);
	}
	public IllegalParameterException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected StatusCode getStatusCode() {
		return super.statusCode != null ? super.statusCode : StatusCode.BAD_REQUEST;
	}
}
