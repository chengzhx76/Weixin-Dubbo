package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 支付类型
 * Author: 光灿
 * Date: 2016/6/18
 */
public class PayType extends DataEntity<PayType> {
    private String name;

    public String getName() {
        return name;
    }

    public PayType setName(String name) {
        this.name = name;
        return this;
    }
}
