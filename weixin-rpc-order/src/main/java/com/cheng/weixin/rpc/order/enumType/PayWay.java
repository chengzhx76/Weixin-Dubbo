package com.cheng.weixin.rpc.order.enumType;

/**
 * Desc: 支付类型：在线，到付
 * Author: hp
 * Date: 2016/9/12
 */
public enum PayWay {
    ONLINE("在线"),
    OFFLINE("线下");

    private String name;

    PayWay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
