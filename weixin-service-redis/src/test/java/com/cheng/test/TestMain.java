package com.cheng.test;

import com.cheng.weixin.service.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc: Spring 容器启动类
 * Author: Cheng
 * Date: 2016/4/21 0021
 */
public class TestMain {
    private static final Logger log = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-context.xml");

            RedisService redis = context.getBean(RedisService.class);
            redis.set("Token","4566855236965823333");
            System.out.println("======");
//            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
            log.error("content start error==>" + e);
        }

//        synchronized (TimerMain.class) {
//            while (true) {
//                try {
//                    TimerMain.class.wait();
//                } catch (InterruptedException e) {
//                    log.error("synchronized error==>" + e);
//                }
//            }
//        }

    }

}
