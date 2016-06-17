package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 退单状态
 * Author: cheng
 * Date: 2016/6/6
 */
public class ReturnStatus extends DataEntity<ReturnStatus> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
