package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 退货原因
 * Author: cheng
 * Date: 2016/6/6
 */
public class ReturnReason extends DataEntity<ReturnReason> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
