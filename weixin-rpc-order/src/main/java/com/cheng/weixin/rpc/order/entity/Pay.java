package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 支付方式：微信支付，支付宝支付，货到付款
 * Author: cheng
 * Date: 2016/6/6
 */
public class Pay extends DataEntity<Pay> {
    private String name;
    private int orderBy;

    public Pay() {
    }

    public Pay(String id) {
        super.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }
}
