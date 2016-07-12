/**
 * 
 */
package com.cheng.weixin.web.mobile.exception;


import com.cheng.weixin.web.mobile.exception.message.HttpCode;

/**
 * Desc: 异常
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

	public IllegalParameterException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.BAD_REQUEST;
	}
}
