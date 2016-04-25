package com.cheng.weixin.rpc.rabbitmq.service;

/**
 * Desc: Rabbit接口
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
public interface RpcRabbitService {
    /**
     * 保存日志
     * @param obj
     */
    void saveLogs(Object obj);
}
