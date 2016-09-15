package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/14
 */
@Service("sysOrderService")
public class SysOrderService {

    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    public void buy() {
        Set<String> productIds = cartService.getChooseProductIds("1");
        for (String productId : productIds) {
            Long count = cartService.getCounts("1", productId);
            Product product = productService.getById(productId);

        }
    }

}
