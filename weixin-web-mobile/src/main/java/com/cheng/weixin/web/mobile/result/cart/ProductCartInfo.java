package com.cheng.weixin.web.mobile.result.cart;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Desc: 购物车商品信息
 * Author: hp
 * Date: 2016/9/8
 */
public class ProductCartInfo {
    private Integer count;
    private String totalPrice;
    private String freight;
    private String freeFreightAmount;
    private Boolean choose;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getFreeFreightAmount() {
        return freeFreightAmount;
    }

    public void setFreeFreightAmount(String freeFreightAmount) {
        this.freeFreightAmount = freeFreightAmount;
    }

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
