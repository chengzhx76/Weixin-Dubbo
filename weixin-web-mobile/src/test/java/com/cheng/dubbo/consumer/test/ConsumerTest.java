package com.cheng.dubbo.consumer.test;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.common.utils.JSONUtils;
import com.cheng.weixin.rabbitmq.model.SmsModel;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.message.service.RpcSmsService;
import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitSmsService;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import com.cheng.weixin.rpc.system.entity.Ad;
import com.cheng.weixin.rpc.system.entity.Notice;
import com.cheng.weixin.rpc.system.service.RpcSystemService;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
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
    @Autowired
    private RpcRedisService redisService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcSystemService systemService;
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcSmsService smsService;
    @Autowired
    private RpcRabbitSmsService rabbitSmsService;

    @Test
    public void testRedis() {
        System.out.println(redisService.set("122","18600536683"));
        //String data = (String) redisService.get("122");
        boolean result = redisService.exists("122");
        System.out.println("=======> "+result);
    }

    @Test
    public void testAddCart() {
        long count = cartService.addProductCount("1","1");
        System.out.println("=========> "+count);

        Set<String> productIds = cartService.getProductIds("1");
        for (String productId : productIds) {
            System.out.println("=======> "+productId);
        }
    }

    @Test
    public void testGetCart() {
        ShoppingCart cartInfo = cartService.getShoppingCart("1");
        System.out.println("=========> "+JSON.toJSONString(cartInfo));
    }

    @Test
    public void testProduct() {
        Product product = productService.getById("1");
        System.out.println("============> "+ product);
    }

    @Test
    public void testSys() {
        List<Ad> ads = systemService.getIndexAds();
        for (Ad ad : ads) {
            System.out.println("=========> "+ad);
        }
        List<Notice> notices = systemService.getIndexNotices();
        for (Notice notice : notices) {
            System.out.println("=========> "+notice);
        }
    }

    @Test
    public void testSaveAccess() {
        userService.saveAccess("18600536683","123456","Cheng","127.0.0.1");
    }

    @Test
    public void testLogin() {
        String data = userService.validateLogin("18600536683", "123456", "127.0.0.1");
        System.out.println("=====> "+ data);
    }

    @Test
    public void testSms() {
        int countByDay = smsService.getCountByDay("18600536683");
        System.out.println("=========>" + countByDay);
    }

    @Test
    public void testRabbitSms() {
        SmsModel smsModel = new SmsModel();
        smsModel.setUserIp("127.0.0.2");
        smsModel.setPhone("18600536683");
        rabbitSmsService.sendValidate(smsModel);
    }

}
