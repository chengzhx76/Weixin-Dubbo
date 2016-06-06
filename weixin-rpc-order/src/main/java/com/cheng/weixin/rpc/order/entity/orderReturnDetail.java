package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

import java.math.BigDecimal;

/**
 * Desc: 退单子项
 * Author: cheng
 * Date: 2016/6/6
 */
public class OrderReturnDetail extends DataEntity<OrderReturnDetail> {
    private String returnOid;
    private String no;
    private String name;
    private int quantity;
    private BigDecimal subtatal;
    private BigDecimal marketPrice;
    private BigDecimal salePrice;
    private BigDecimal dealPrice;
    private double discountRate;
    private boolean isGift;

    public String getReturnOid() {
        return returnOid;
    }

    public void setReturnOid(String returnOid) {
        this.returnOid = returnOid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtatal() {
        return subtatal;
    }

    public void setSubtatal(BigDecimal subtatal) {
        this.subtatal = subtatal;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }
}
