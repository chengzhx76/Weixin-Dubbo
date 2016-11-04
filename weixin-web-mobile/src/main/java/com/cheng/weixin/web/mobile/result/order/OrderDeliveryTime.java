package com.cheng.weixin.web.mobile.result.order;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/16
 */
public class OrderDeliveryTime {
    private String value;
    private String title;

    public OrderDeliveryTime() {
    }

    public OrderDeliveryTime(String id, String name) {
        this.value = id;
        this.title = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

