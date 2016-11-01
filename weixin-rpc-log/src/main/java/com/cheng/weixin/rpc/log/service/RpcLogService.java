package com.cheng.weixin.rpc.log.service;

import java.util.Map;

/**
 * Desc: 日志
 * Author: Cheng
 * Date: 2016/4/7 0007
 */
public interface RpcLogService {
    /**
     * 保存日志
     * @param remoteAddr 操作用户的IP地址
     * @param userAgent 操作用户的代理信息
     * @param requestUri 操作的URI
     * @param params 操作提交的数据
     * @param method 操作的方式 GET或POST
//     * @param handler // 里面有内容不支持序列化；需要在前端把值取出来 传过来 TODO 以后实现
     * @param ex 异常信息
     * @param title 标题
     * @param username 操作人用户名
     */
    void saveLog(String remoteAddr, String userAgent, String requestUri, Map<String, String[]> params, String method,
                 /*Object handler,*/ Exception ex, String title, String username);

}
