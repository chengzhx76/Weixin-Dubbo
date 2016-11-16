package com.cheng.weixin.rpc.order.enumType;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/16
 */
public enum OrderStatus {
    INVALID("无效的订单"), // 前端用的
    COMMENT("等待评论"),

    WAIT_PAY("等待付款"), // 倒计时15分钟内付款 进入下一个流程，否则进入付款超时（已失效）
    ONGOING("进行中"), //
    PAY_OUT_TIME("付款超时"),
    WAIT_REFUND("等待退款"),
    REFUNDED("已退款"),
    CANCELED("已取消"),
    UNFINISHED("未完成"),
    FINISHED("完成");

    private String name;
    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
