package com.cheng.weixin.rpc.cart.service;

import java.util.Set;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/28
 */
public interface RpcCartService {
    /**
     * 增加商品的数量
     * @param userId
     * @param productId
     * @param count
     */
    void addProductCount(String userId, String productId, Integer count);

    /**
     * 获取购物车中所有商品的ID
     * @param userId
     * @return
     */
    Set<String> getProductIds(String userId);

}
