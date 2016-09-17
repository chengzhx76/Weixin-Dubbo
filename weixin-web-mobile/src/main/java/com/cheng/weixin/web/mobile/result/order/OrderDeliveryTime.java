package com.cheng.weixin.web.mobile.result.order;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/16
 */
public class OrderDeliveryTime {
    private String id;
    private String name;

    public OrderDeliveryTime() {
    }

    public OrderDeliveryTime(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
