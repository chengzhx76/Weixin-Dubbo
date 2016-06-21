package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.model.enumType.HttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

/**
 * Desc: 基础Controller
 * Author: cheng
 * Date: 2016/6/21
 */
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());




















    /** 设置成功响应代码 */
    protected ResponseEntity<Response> success() {
        return setResponse(HttpCode.OK, true, Response.OK, null);
    }
    /** 设置成功响应代码 */
    protected ResponseEntity<Response> success(Object data) {
        return setResponse(HttpCode.OK, true, Response.OK, data);
    }
    /** 设置成功响应代码 */
    protected ResponseEntity<Response> success(String message, Object data) {
        return setResponse(HttpCode.OK, true, message, null);
    }

    /** 设置失败响应代码 */
    protected ResponseEntity<Response> failure() {
        return setResponse(HttpCode.BAD_REQUEST, false, Response.ERROR, null);
    }
    /** 设置失败响应代码 */
    protected ResponseEntity<Response> failure(HttpCode code, String message) {
        return setResponse(code, false, message, null);
    }
    /** 设置失败响应代码 */
    protected ResponseEntity<Response> failure(String message) {
        return setResponse(HttpCode.BAD_REQUEST, false, message, null);
    }

    /**
     * 响应报文
     * @param code 状态码
     * @param success 是否成功
     * @param message 消息
     * @param data 数据
     * @return 响应实体
     */
    protected ResponseEntity<Response> setResponse(HttpCode code, boolean success, String message, Object data) {
        return ResponseEntity.ok(new Response(code.value(), success, message, data));
    }

}
