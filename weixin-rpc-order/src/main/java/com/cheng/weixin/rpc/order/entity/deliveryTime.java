package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 配送时间
 * Author: cheng
 * Date: 2016/6/6
 */
public class DeliveryTime extends DataEntity<DeliveryTime>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
