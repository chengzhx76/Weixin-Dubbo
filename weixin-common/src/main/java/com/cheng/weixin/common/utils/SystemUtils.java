package com.cheng.weixin.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 系统工具 获取验证码
 * Author: 光灿
 * Date: 2016/7/9
 */
public class SystemUtils {
    /**
     * 获取远程用户的地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if(StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (StringUtils.isBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }
}
