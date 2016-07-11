package com.cheng.test;

import com.cheng.weixin.rpc.message.service.RpcSmsService;
import com.cheng.weixin.service.message.model.SmsModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/7/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcSmsService smsService;

    @Test
    public void testSendMsgCode() {
        SmsModel smsModel = new SmsModel();
        smsModel.setUserIp("127.0.0.1");
        smsModel.setPhone("18600536683");

        //String data = objectMapper.toJsonString(smsModel); // Rabbit自带json序列化
        //smsService.sendRegMsgCode(smsModel);
    }
}
