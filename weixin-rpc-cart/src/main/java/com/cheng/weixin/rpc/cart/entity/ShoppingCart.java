package com.cheng.weixin.rpc.cart.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/6
 */
public class ShoppingCart extends DataEntity<ShoppingCart> {
    private int accessId;
    private int totalQuantity;

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
