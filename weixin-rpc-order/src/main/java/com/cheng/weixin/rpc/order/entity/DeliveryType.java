package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 配送方式：上门自提；第三方运输
 * Author: cheng
 * Date: 2016/6/6
 */
@Deprecated
public class DeliveryType extends DataEntity<DeliveryType> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
