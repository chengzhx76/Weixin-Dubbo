package com.cheng.weixin.rpc.cart.service;

import com.cheng.weixin.rpc.cart.entity.ShoppingCart;

import java.util.Set;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/28
 */
public interface RpcCartService {

    ///**
    // * 商品递增1
    // * @param userId
    // * @param productId
    // */
    //void addProductCount(String userId, String productId);

    /**
     * 递增商品的数量
     * @param userId 用户ID
     * @param productId 商品ID
     * @return 增加后的商品数量
     */
    Long addProductCount(String userId, String productId);

    /**
     * 减少商品数量
     * @param userId 用户ID
     * @param productId 商品ID
     * @return 减少后的商品数量
     */
    Long subProductCount(String userId, String productId);

    /**
     * 获取购物车中所有商品的ID
     * @param userId 用户ID
     * @return 该用户购物车中所有商品的ID
     */
    Set<String> getProductIds(String userId);

    /**
     * 根据用户id获取和商品ID获取商品个数
     * @param userId
     * @param productId
     * @return
     */
    Long getCounts(String userId, String productId);

    /**
     * 删除购物车中的商品
     * @param userId 用户ID
     * @param productId 商品ID
     */
    void deleteProduct(String userId, String productId);
    /**
     * 批量删除商品
     * @param userId
     * @param productIds
     */
    void batchDeteleProduct(String userId, String[] productIds);

    /**
     * 获取购物车的信息
     * @param accessId 用户ID
     * @return 购物车的商品
     */
    ShoppingCart getShoppingCart(String accessId);

    /**
     * 添加商品
     * @param userId
     * @param productId
     * @param count
     */
    void addProduct(String userId, String productId, int count);
}
