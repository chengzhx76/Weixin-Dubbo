package com.cheng.test;

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
}
