package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 镇
 * Author: hp
 * Date: 2016/11/3
 */
public class Town extends DataEntity<Town> {
    private String name;

    public Town() {
    }
    public Town(String id) {
        super.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
