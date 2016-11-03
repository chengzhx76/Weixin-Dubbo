package com.cheng.weixin.web.mobile.result.cart;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Desc: 购物车
 * Author: hp
 * Date: 2016/8/26
 */
public class ShoppingCartInfo {
    private String consignee;
    private String address;
    private String mobile;
    private String deliveryDate;
    private String totalPrice;
    private String freight;
    private String freeFreightAmount;
    private int hasNum;
    private List<ProductInfo> products;

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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

    public int getHasNum() {
        return hasNum;
    }

    public void setHasNum(int hasNum) {
        this.hasNum = hasNum;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
