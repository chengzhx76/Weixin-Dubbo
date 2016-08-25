package com.cheng.weixin.rpc.cart.entity;

import com.cheng.common.entity.DataEntity;

import java.util.List;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/6
 */
public class ShoppingCart extends DataEntity<ShoppingCart> {
    private String accessId;
    private int totalQuantity;

    private List<CartInfo> cartInfos;

    public String getAccessId() {
        return accessId;
    }

    public ShoppingCart setAccessId(String accessId) {
        this.accessId = accessId;
        return this;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<CartInfo> getCartInfos() {
        return cartInfos;
    }

    public ShoppingCart setCartInfos(List<CartInfo> cartInfos) {
        this.cartInfos = cartInfos;
        return this;
    }
}
