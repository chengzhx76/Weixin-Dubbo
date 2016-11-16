package com.cheng.weixin.rpc.order.enumType;

/**
 * Desc: 订单类型 正常-退货-返回换货
 * Author: cheng
 * Date: 2016/6/6
 */
public enum OrderType {
    NORMAL("正常"),
    RETURN("退货"),
    RETURN_EXCHANGE("返回换货");

    private String name;

    OrderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}