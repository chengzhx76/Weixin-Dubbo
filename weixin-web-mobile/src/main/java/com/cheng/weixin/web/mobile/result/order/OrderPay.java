package com.cheng.weixin.web.mobile.result.order;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/16
 */
public class OrderPay {
    private String id;
    private String name;
    private String icon;

    public OrderPay() {
    }

    public OrderPay(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
