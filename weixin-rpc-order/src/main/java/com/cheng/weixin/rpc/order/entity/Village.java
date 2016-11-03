package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 村庄
 * Author: hp
 * Date: 2016/11/3
 */
public class Village extends DataEntity<Village> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
