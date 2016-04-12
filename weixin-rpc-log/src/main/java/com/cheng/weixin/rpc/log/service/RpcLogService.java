package com.cheng.weixin.rpc.log.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 日志
 * Author: Cheng
 * Date: 2016/4/7 0007
 */
public interface RpcLogService {
    /**
     * 保存日志
     * @param request
     * @param handler
     * @param ex
     * @param title
     * @param useranem
     */
    void saveLog(HttpServletRequest request, Object handler, Exception ex, String title, String useranem);
}
