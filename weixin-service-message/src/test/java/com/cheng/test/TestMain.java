package com.cheng.test;

import com.cheng.weixin.rabbitmq.model.SmsModel;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import com.cheng.weixin.rpc.message.enums.MsgType;
import com.cheng.weixin.rpc.message.service.RpcSmsService;
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

        smsService.sendValidate(smsModel);
    }

    @Test
    public void testGetCountByDay() {
        int count = smsService.getCountByDay("18600536683");
        System.out.println(count);
    }
    @Test
    public void testGetCountByIP() {
        int count = smsService.getCountByIp("127.0.0.1");
        System.out.println(count);
    }
    @Test
    public void checkMsgCode() {
        SmsHistory smsHistory = smsService.getInfoByPhoneAndType("18600536683", MsgType.VALIDATE);
        System.out.println(smsHistory);
    }

}
