package com.cheng.weixin.web.mobile.result.order;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Desc: 订单详情
 * Author: hp
 * Date: 2016/9/28
 */
public class OrderDetail {
    private String id;
    private String status;
    private String oid;
    private String addTime;
    private String consignee;
    private String address;
    private String mobile;
    private String payWay;

    private String productTotalPrice;
    private String freightPayable;
    private String couponReducePrice;
    private String balanceOffset;
    private String totalPrice;
    private String orderStatus;

    private String commentId;

    private List<OrderProductDetail> details;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

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

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(String productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getFreightPayable() {
        return freightPayable;
    }

    public void setFreightPayable(String freightPayable) {
        this.freightPayable = freightPayable;
    }

    public String getCouponReducePrice() {
        return couponReducePrice;
    }

    public void setCouponReducePrice(String couponReducePrice) {
        this.couponReducePrice = couponReducePrice;
    }

    public String getBalanceOffset() {
        return balanceOffset;
    }

    public void setBalanceOffset(String balanceOffset) {
        this.balanceOffset = balanceOffset;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderProductDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderProductDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
