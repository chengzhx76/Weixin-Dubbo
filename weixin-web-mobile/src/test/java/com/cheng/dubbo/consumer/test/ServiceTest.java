package com.cheng.dubbo.consumer.test;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.web.mobile.result.index.Index;
import com.cheng.weixin.web.mobile.result.order.SubmitOrderInfo;
import com.cheng.weixin.web.mobile.service.SysIndexService;
import com.cheng.weixin.web.mobile.service.SysOrderService;
import com.cheng.weixin.web.mobile.service.SysProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    private SysIndexService indexService;
    @Autowired
    private SysOrderService orderService;
    @Autowired
    private SysProductService productService;


    @Test
    public void test01() {
        Index index = indexService.getIndexInfo("1");
        System.out.println(JSON.toJSONString(index));
    }

    @Test
    public void test02() {
        SubmitOrderInfo info = orderService.buy();
        System.out.println(JSON.toJSONString(info));
    }
    @Test
    public void test03() {
        orderService.submitOrder();
    }
    @Test
    public void test04() {
        System.out.println(orderService.getOrders());
    }
    @Test
    public void test05() {
        System.out.println(orderService.getOrderDetail());
    }

    // ========================================================= //

    @Test
    public void test06() {
        System.out.println(productService.getDetail("1"));
    }
    @Test
    public void test07() {
        productService.buyProduct("1", 2L);
    }
    @Test
    public void test08() {
        System.out.println(productService.focus("1"));
    }
}
