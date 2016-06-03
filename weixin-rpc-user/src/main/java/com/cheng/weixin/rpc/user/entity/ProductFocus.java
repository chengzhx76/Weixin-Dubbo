package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 关注商品
 * Author: cheng
 * Date: 2016/6/3
 */
public class ProductFocus extends DataEntity<ProductFocus> {
    private int accountId;
    private int productId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
