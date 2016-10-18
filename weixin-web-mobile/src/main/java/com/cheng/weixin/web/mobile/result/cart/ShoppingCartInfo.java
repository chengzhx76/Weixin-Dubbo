package com.cheng.weixin.web.mobile.result.cart;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Desc: 购物车
 * Author: hp
 * Date: 2016/8/26
 */
public class ShoppingCartInfo {

    private String deliveryDate;
    private String totalPrice;
    private List<ProductInfo> products;

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductInfo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfo> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
