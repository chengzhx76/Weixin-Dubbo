package com.cheng.weixin.rpc.message.service;


import com.cheng.weixin.rabbitmq.model.SmsModel;

/**
 * Desc: 短信服务
 * Author: 光灿
 * Date: 2016/7/10
 */
public interface RpcSmsService {
    /**
     * 发送注册短信
     */
    void sendValidate(SmsModel smsModel);

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
