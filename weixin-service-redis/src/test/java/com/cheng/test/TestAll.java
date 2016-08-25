package com.cheng.test;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

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
        boolean data = redisService.exists("website");
        System.out.println("======> "+data);
    }

    @Test
    public void test02() {
        long data = redisService.increase("user-12","1");
        System.out.println("======> "+data);
    }
    @Test
    public void test03() {
        Object obj = redisService.getValueByKeyANdField("user-11","1");
        System.out.println(obj);
    }
    @Test
    public void test04() {
        Map<Serializable, Object> datas = redisService.getEntries("CART_1");

        Set<Serializable> fields = datas.keySet();
        for (Serializable field : fields) {
            System.out.println("====> Value: "+field + " Key: " + datas.get(field));
        }
    }
}
