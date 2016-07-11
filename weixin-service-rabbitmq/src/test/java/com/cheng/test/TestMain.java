package com.cheng.test;

import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/7/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class TestMain {
    @Autowired
    private RabbitTemplate smsTemplate;
    @Autowired
    private RpcRabbitSmsService rabbitSmsService;

    @Test
    public void testSendReg() {
        smsTemplate.convertAndSend("SMS-REGISTER", "生产者发送SMS-REGISTER");
    }
    @Test
    public void testSendNotice() {
        smsTemplate.convertAndSend("SMS-NOTICE", "生产者发送SMS-NOTICE");
    }
    @Test
    public void testSendActive() {
        smsTemplate.convertAndSend("SMS-ACTIVITY", "生产者发送SMS-ACTIVITY");
    }

    @Test
    public void testSendMsgCode() throws Exception {
        SmsModel smsModel = new SmsModel();
        smsModel.setUserIp("127.0.0.1");
        smsModel.setPhone("18600536683");

        //String data = objectMapper.toJsonString(smsModel); // Rabbit自带json序列化


        rabbitSmsService.sendRegMsgCode(smsModel);
    }
}
