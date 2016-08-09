package com.cheng.dubbo.consumer.test;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class ConsumerTest {
    @Autowired
    private RpcRedisService redisService;
    //@Autowired
    //private RpcCartService cartService;
    //@Autowired
    //private RpcProductService productService;
    //@Autowired
    //private RpcSystemService systemService;
    //@Autowired
    //private RpcSmsService smsService;
    //@Autowired
    //private RpcRabbitSmsService rabbitSmsService;
    //@Autowired
    //private RpcUserService userService;

    @Test
    public void testRedis() {
        System.out.println(redisService.set("122","18600536683"));
        //String data = (String) redisService.get("122");
        boolean result = redisService.exists("122");
        System.out.println("=======> "+result);
    }

    //@Test
    //public void testCart() {
    //    long count = cartService.addProductCount("1","1");
    //    System.out.println("=========> "+count);
    //
    //    Set<String> productIds = cartService.getProductIds("1");
    //    for (String productId : productIds) {
    //        System.out.println("=======> "+productId);
    //    }
    //}
    //
    //@Test
    //public void testProduct() {
    //    Product product = productService.getById("1");
    //    System.out.println("============> "+ product);
    //}
    //
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

    //@Test
    //public void testSms() {
    //    int countByDay = smsService.getCountByDay("18600536683");
    //    System.out.println("=========>" + countByDay);
    //}
    //
    //@Test
    //public void testRabbitSms() {
    //    SmsModel smsModel = new SmsModel();
    //    smsModel.setUserIp("127.0.0.1");
    //    smsModel.setPhone("18600536683");
    //
    //    rabbitSmsService.sendValidate(smsModel);
    //}

    //@Test
    //public void testSaveAccess() {
    //    userService.saveAccess("18600536683","123456","Cheng","127.0.0.1");
    //}
}
