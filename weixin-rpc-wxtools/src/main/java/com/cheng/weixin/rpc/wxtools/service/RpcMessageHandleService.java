package com.cheng.weixin.rpc.wxtools.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Desc: 消息处理
 * Author: Cheng
 * Date: 2016/4/7 0007
 */
public interface RpcMessageHandleService {
    /**
     * 把XML转换程Map对象
     * @param request
     * @return
     */
    Map<String, String> reqMsg2Map(HttpServletRequest request);
    /**
     * 微信消息处理入口
     * @param msgMap
     * @return
     */
    String handleResp(Map<String, String> msgMap);
}
