package com.cheng.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/4/22 0022
 */
public class SpringMain {

    public static void main(String args[]) throws Exception {

        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("context-direct.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);


        UserModel user = new UserModel();
        user.setUsername("张三");
        user.setPassword("12300");
        user.setSex("nan");

        template.convertAndSend("mq-test", "sss");
        Thread.sleep(1000);
        ctx.destroy();
    }
}
