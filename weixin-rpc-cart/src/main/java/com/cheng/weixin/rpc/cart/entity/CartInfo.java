package com.cheng.weixin.rpc.cart.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 购物车子
 * Author: cheng
 * Date: 2016/6/6
 */
public class CartInfo extends DataEntity<CartInfo>  {
    private int accessId;
    private int productId;
    private int quantity;

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
