package com.cheng.weixin.cart.test;

import com.cheng.weixin.rpc.cart.service.RpcCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/7/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class TestCart {
    @Autowired
    private RpcCartService cartService;

    @Test
    public void testAdd() {
        Long data = cartService.addProductCount("1", "1");
        System.out.println("testAdd======> "+data);
    }

    @Test
    public void testGet() {
        Long data = cartService.getCounts("1", "1");
        System.out.println("testGet======> "+data);
    }
}
