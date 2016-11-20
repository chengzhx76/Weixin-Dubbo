package com.cheng.weixin.rpc.rabbitmq.service;

/**
 * Desc: Rabbit接口
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
public interface RpcRabbitSmsService {

    String VALIDATE = "SMS-VALIDATE";
    String NOTICE = "SMS-NOTICE";
    String ACTIVITY = "SMS-ACTIVITY";

    /**
     * 发送注册短消息
     * @param msgData
     */
    void sendValidate(Object msgData);

    /**
     * 现金通知
     * @param msgData
     */
    void sendCashNotify(Object msgData);
}
