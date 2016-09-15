package com.cheng.weixin.web.mobile.result.order;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/15
 */
public class OrderInfo {
    private String consignee;
    private String address;
    private String mobile;
    private String[] deliveryTime;
    private String[] pays;
    private int availableCoupon;
    private String availableBalance;
    private String remark;
    private String[] productImgs;
    private int totalProductNums;
    private String totalProductPrice;
    private String freight;
    private String couponRecord;
    private String totalPrice;

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

    public String[] getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String[] deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String[] getPays() {
        return pays;
    }

    public void setPays(String[] pays) {
        this.pays = pays;
    }

    public int getAvailableCoupon() {
        return availableCoupon;
    }

    public void setAvailableCoupon(int availableCoupon) {
        this.availableCoupon = availableCoupon;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String[] getProductImgs() {
        return productImgs;
    }

    public void setProductImgs(String[] productImgs) {
        this.productImgs = productImgs;
    }

    public int getTotalProductNums() {
        return totalProductNums;
    }

    public void setTotalProductNums(int totalProductNums) {
        this.totalProductNums = totalProductNums;
    }

    public String getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(String totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getCouponRecord() {
        return couponRecord;
    }

    public void setCouponRecord(String couponRecord) {
        this.couponRecord = couponRecord;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
