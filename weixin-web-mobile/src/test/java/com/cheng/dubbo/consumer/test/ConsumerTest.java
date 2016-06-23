package com.cheng.dubbo.consumer.test;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class ConsumerTest {
    @Resource
    private RpcRedisService redisService;

    @Test
    public void test01() {
        String data = (String) redisService.get("122");

        System.out.println(redisService.set("122","测试!"));

        System.out.println("=======> "+data);
    }
}
