package com.cheng.weixin.rpc.message.service;

/**
 * Desc: 短信服务
 * Author: 光灿
 * Date: 2016/7/10
 */
public interface RpcSmsService {
    /**
     * 发送注册短信
     */
    void sendRegMsg(String msgData);

    /**
     * 发送通知短信
     * @param msgData
     */
    void sendNotice(String msgData);

    /**
     * 发送活动短信
     * @param msgData
     */
    void sendActivity(String msgData);

}
