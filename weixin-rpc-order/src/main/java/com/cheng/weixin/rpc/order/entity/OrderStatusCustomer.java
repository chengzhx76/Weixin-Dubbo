package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 订单状态表-客服
 * Author: cheng
 * Date: 2016/6/6
 */
public class OrderStatusCustomer extends DataEntity<OrderStatusCustomer> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
