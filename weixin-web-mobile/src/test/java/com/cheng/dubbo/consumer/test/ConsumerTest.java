package com.cheng.dubbo.consumer.test;

import com.cheng.weixin.rpc.cart.service.RpcCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class ConsumerTest {
    //@Autowired
    //private RpcRedisService redisService;
    @Autowired
    private RpcCartService cartService;
    //@Autowired
    //private RpcProductService productService;
    //@Autowired
    //private RpcSystemService systemService;

    //@Test
    //public void testRedis() {
    //    //String data = (String) redisService.get("122");
    //    //System.out.println(redisService.set("122","18600536683"));
    //    boolean result = redisService.exists("122");
    //    System.out.println("=======> "+result);
    //}

    @Test
    public void testCart() {
        long count = cartService.addProductCount("1","1");
        System.out.println("=========> "+count);

        Set<String> productIds = cartService.getProductIds("1");
        for (String productId : productIds) {
            System.out.println("=======> "+productId);
        }
    }

    //@Test
    //public void testProduct() {
    //    Product product = productService.getById("1");
    //    System.out.println("============> "+ product);
    //}

    //@Test
    //public void testSys() {
    //    List<Ad> ads = systemService.getIndexAds();
    //    for (Ad ad : ads) {
    //        System.out.println("=========> "+ad);
    //    }
    //    List<Notice> notices = systemService.getIndexNotices();
    //    for (Notice notice : notices) {
    //        System.out.println("=========> "+notice);
    //    }
    //}
}
