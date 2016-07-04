package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.exception.BaseException;
import com.cheng.weixin.web.mobile.exception.IllegalParameterException;
import com.cheng.weixin.web.mobile.exception.message.HttpCode;
import com.cheng.weixin.web.mobile.json.CustomObjectMapper;
import com.cheng.weixin.web.mobile.model.Meta;
import com.cheng.weixin.web.mobile.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Desc: 基础Controller
 * Author: cheng
 * Date: 2016/6/21
 */
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomObjectMapper objectMapper;

    // 封装参数方法
    protected Object getDto(HttpServletRequest request, Class clazz) {
        try {
            String param = request.getParameter("param");
            param = URLDecoder.decode(param, "UTF-8");
            return objectMapper.fromJsonString(param, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /** 设置成功响应代码 */
    protected ResponseEntity<Response> success() {
        return setResponse(HttpCode.OK, true, HttpCode.OK.msg(), null);
    }
    /** 设置成功响应代码 */
    protected ResponseEntity<Response> success(Object data) {
        return setResponse(HttpCode.OK, true, HttpCode.OK.msg(), data);
    }

    /** 设置失败响应代码 */
    protected ResponseEntity<Response> failure() {
        return setResponse(HttpCode.BAD_REQUEST, false, HttpCode.BAD_REQUEST.msg(), null);
    }
    /** 设置失败响应代码 */
    protected ResponseEntity<Response> failure(HttpCode code) {
        return setResponse(code, false, code.msg(), null);
    }



    /** 设置成功响应代码 */
    @Deprecated
    protected ResponseEntity<Response> success(String message, Object data) {
        return setResponse(HttpCode.OK, true, message, null);
    }

    /** 设置失败响应代码 */
    @Deprecated
    protected ResponseEntity<Response> failure(String message) {
        return setResponse(HttpCode.BAD_REQUEST, false, message, null);
    }
    /** 设置失败响应代码 */
    @Deprecated
    protected ResponseEntity<Response> failure(HttpCode code, String message) {
        return setResponse(code, false, message, null);
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
        return setResponse(code.value(), success, message, data);
    }
    protected ResponseEntity<Response> setResponse(int code, boolean success, String message, Object data) {
        return ResponseEntity.ok(new Response(code, success, message, data));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        logger.error("发生异常==> ", ex);
        Meta meta = new Meta();
        if (ex instanceof BaseException) {
            ((BaseException) ex).handler(meta);
        } else if (ex instanceof IllegalArgumentException) {
            new IllegalParameterException(ex.getMessage()).handler(meta);
        } else {
            meta.setSuccess(false);
            meta.setCode(HttpCode.INTERNAL_SERVER_ERROR.value());
            meta.setMsg(HttpCode.INTERNAL_SERVER_ERROR.msg());
        }

        return ResponseEntity.ok(new Response(meta.getCode(), meta.isSuccess(), meta.getMsg(), null));

        /*String callbackParam = request.getParameter("callback");
        response.setContentType("application/json;charset=UTF-8");
        String data = JSON.toJSONString(new Response(meta.getCode(), meta.isSuccess(), meta.getMsg(), ""));
        if(StringUtils.isNotBlank(callbackParam)) {
            data = callbackParam+"("+ data +")";
        }
        response.getWriter().write(data);
        response.getWriter().flush();
        response.getWriter().close();*/
    }
}
