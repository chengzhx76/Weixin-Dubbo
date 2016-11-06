package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rpc.order.enumType.PayWay;

/**
 * Desc: 支付方式：微信支付，支付宝支付，货到付款
 * Author: cheng
 * Date: 2016/6/6
 */
public class Pay extends DataEntity<Pay> {
    private String name;
    private PayWay payWay;
    private String icon;
    private int orderBy;
    private Boolean recommend;

    public Pay() {
    }

    public Pay(String id) {
        super.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PayWay getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWay payWay) {
        this.payWay = payWay;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }
}
