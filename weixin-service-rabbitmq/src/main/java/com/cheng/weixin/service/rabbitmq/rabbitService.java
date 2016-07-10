package com.cheng.weixin.service.rabbitmq;

import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 消息列队
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
@Service("rabbitService")
public class RabbitService implements RpcRabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void saveLogs(Object obj) {
        rabbitTemplate.convertAndSend("WEIXIN-LOG", obj);
    }

    @Override
    public void sendRegMsgCode(String data) {
        rabbitTemplate.convertAndSend("REG-MSG", data);
    }

}
