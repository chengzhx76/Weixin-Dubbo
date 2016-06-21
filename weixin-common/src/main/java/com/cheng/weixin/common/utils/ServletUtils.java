package com.cheng.weixin.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: Http和Servlet工具类
 * Author: Cheng
 * Date: 2016/3/29 0029
 */
public class ServletUtils {
    /**
     * 获取当期请求对象
     * @return
     */
    public static HttpServletRequest getRequest() {

        RequestAttributes requestAttributes1 = RequestContextHolder.currentRequestAttributes();
        RequestAttributes requestAttributes2 = RequestContextHolder.getRequestAttributes();


        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
