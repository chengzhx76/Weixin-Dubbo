package com.cheng.weixin.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Cheng
 * Date: 2016/1/27 0027
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 获取远程用户的地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if(isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }
}
