package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc:自提配送时间
 * Author: 光灿
 * Date: 2016/6/18
 */
public class ArayacakDeliveryTime extends DataEntity<ArayacakDeliveryTime> {
    private String name;

    public String getName() {
        return name;
    }

    public ArayacakDeliveryTime setName(String name) {
        this.name = name;
        return this;
    }
}
