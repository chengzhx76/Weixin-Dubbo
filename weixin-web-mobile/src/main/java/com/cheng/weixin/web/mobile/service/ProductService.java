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
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("productService")
public class ProductService {
    //@Autowired
    //private RpcRedisService redisService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    /**
     * 获取首页购物车总商品的价格
     * @param userId
     * @return
     */
    public BigDecimal getIndexProductTotalPrice(String userId) {
        Set<String> pids =  cartService.getProductIds(userId);
        BigDecimal totalPrice = new BigDecimal(0);
        for (String pid : pids) {
            Product product = productService.getById(pid);
            totalPrice.add(product.getSalePrice());
        }
        return totalPrice;
    }

}
