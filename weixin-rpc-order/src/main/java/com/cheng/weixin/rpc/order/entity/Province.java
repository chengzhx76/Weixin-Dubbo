package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 省
 * Author: hp
 * Date: 2016/11/3
 */
public class Province extends DataEntity<Province> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
