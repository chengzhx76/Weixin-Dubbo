package com.cheng.test;

import com.cheng.weixin.rpc.user.entity.DeliveryAddress;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/7/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcUserService userService;

    @Test
    public void saveAccess() {
        userService.saveAccess("18600536683","123456","Cheng","127.0.0.1");
    }

    @Test
    public void getDefaultAddress() {
        DeliveryAddress address = userService.getDefaultAddress("1");
        System.out.println(address);
    }

}
