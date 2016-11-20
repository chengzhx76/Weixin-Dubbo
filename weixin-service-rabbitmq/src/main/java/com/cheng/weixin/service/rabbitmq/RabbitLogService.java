package com.cheng.weixin.service.rabbitmq;

import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitLogService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 消息列队
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
@Service("rabbitLogService")
public class RabbitLogService implements RpcRabbitLogService {
    @Autowired
    private RabbitTemplate rabbitLogTemplate;

    @Override
    public void saveLogs(Object obj) {
        rabbitLogTemplate.convertAndSend(LOG, obj);
    }

}
