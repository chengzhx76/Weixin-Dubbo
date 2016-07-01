package com.cheng.test;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/7/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class TestAll {
    @Autowired
    private RpcRedisService redisService;

    @Test
    public void test01() {
        boolean data = redisService.exists("122");
        System.out.println("======> "+data);
    }

    @Test
    public void test02() {
        long data = redisService.increase("user-11","1");
        System.out.println("======> "+data);
    }
    @Test
    public void test03() {
        Object obj = redisService.getValueByKeyANdField("user-11","1");
        Long count = (Long) obj;
        System.out.println(obj);
    }
}
