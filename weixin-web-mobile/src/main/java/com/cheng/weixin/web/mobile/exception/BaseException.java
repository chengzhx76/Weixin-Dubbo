/**
 * 
 */
package com.cheng.weixin.web.mobile.exception;

import com.cheng.weixin.web.mobile.exception.message.HttpCode;
import com.cheng.weixin.web.mobile.model.Meta;
import org.apache.commons.lang3.StringUtils;

/**
 * Desc: 异常
 * Author: cheng
 * Date: 2016/6/21
 */
@SuppressWarnings("serial")
public abstract class BaseException extends RuntimeException {
	public BaseException() {
	}

	public BaseException(Throwable ex) {
		super(ex);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable ex) {
		super(message, ex);
	}

	public void handler(Meta meta) {
		meta.setSuccess(false);
		meta.setCode(getHttpCode().value());
		if (StringUtils.isNotBlank(getMessage())) {
			meta.setMsg(getMessage()); // 取系统的错误消息
		}else {
			meta.setMsg(getHttpCode().msg());
		}
	}

	protected abstract HttpCode getHttpCode();
}
