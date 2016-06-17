package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 退款方式：微信零钱
 * Author: cheng
 * Date: 2016/6/6
 */
public class RefundType extends DataEntity<RefundType> {
    private String name;

    public String getName() {
        return name;
    }

    public RefundType setName(String name) {
        this.name = name;
        return this;
    }
}
