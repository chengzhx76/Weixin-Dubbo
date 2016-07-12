package com.cheng.weixin.rpc.rabbitmq.service;

/**
 * Desc: Rabbit接口
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
public interface RpcRabbitSmsService {

    /**
     * 发送注册短消息
     * @param msgData
     */
    void sendValidate(Object msgData);
}
