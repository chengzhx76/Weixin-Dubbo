package com.cheng.weixin.service.rabbitmq;

import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitSmsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 消息列队
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
@Service("rabbitSmsService")
public class RabbitSmsService implements RpcRabbitSmsService {
    @Autowired
    private RabbitTemplate rabbitSmsTemplate;

    @Override
    public void sendRegMsgCode(Object data) {
        rabbitSmsTemplate.convertAndSend("WEIXIN-SMS-REG", data);
    }

}
