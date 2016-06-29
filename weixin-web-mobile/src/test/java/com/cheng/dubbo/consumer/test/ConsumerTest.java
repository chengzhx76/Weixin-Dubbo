package com.cheng.dubbo.consumer.test;

import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
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
    //@Resource
    //private RpcRedisService redisService;
    //@Resource
    //private RpcCartService cartService;
    @Resource
    private RpcProductService productService;

    //@Test
    //public void test01() {
    //    //String data = (String) redisService.get("122");
    //    //System.out.println(redisService.set("122","chengzhx76"));
    //    boolean result = redisService.exists("122");
    //    System.out.println("=======> "+result);
    //}

    //@Test
    //public void testCart() {
    //    //cartService.addProductCount("1","1",1);
    //
    //    Set<String> productIds = cartService.getProductIds("1");
    //    for (String productId : productIds) {
    //        System.out.println("=======> "+productId);
    //    }
    //}

    @Test
    public void testProduct() {
        Product product = productService.getById("1");
        System.out.println("============> "+ product);
    }

}
