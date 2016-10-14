package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rpc.order.enumType.OrderType;
import com.cheng.weixin.rpc.order.enumType.PayStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Desc: 订单
 * Author: cheng
 * Date: 2016/6/6
 */
public class OrderInfo extends DataEntity<OrderInfo> {
    private String accountId;
    private String oid;
    private String relateOid;
    private BigDecimal amountPayable;
    private BigDecimal amountPaid;
    private String consignee;
    private String mobile;
    private String address;
    private String deliveryTimeId;
    private String payId;
    private String deliveryTypeId;
    private String arayacakAddress;
    private String arayacakDeliveryTime;
    private String province;
    private String city;
    private String country;
    private String villageId;
    private String ip;

    private PayStatus payStatus;
    private String flowStatus;
    private OrderType orderType;
    private BigDecimal freightReduce;
    private BigDecimal freightPayable;
    private BigDecimal productTotalPrice;
    private BigDecimal balanceOffset; // 余额抵扣
    private BigDecimal discount;
    private String remarkCustomer;
    private String postCode;
    private String telephone;
    private String email;
    private Date payTime;
    private String exchangeOid;
    private String customPrice;
    private String couponCode;
    private BigDecimal couponReducePrice;
    //private BigDecimal cashReducePrice;
    private BigDecimal bonusPointReducePrice;
    private boolean isFreeAccountLevel;
    private String commentId;

    public OrderInfo() {
    }

    public OrderInfo(String accountId) {
        this.accountId = accountId;
    }

    public String getVillageId() {
        return villageId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    private List<OrderProductDetail> orderDetails;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRelateOid() {
        return relateOid;
    }

    public void setRelateOid(String relateOid) {
        this.relateOid = relateOid;
    }

    public BigDecimal getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(BigDecimal amountPayable) {
        this.amountPayable = amountPayable;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryTimeId() {
        return deliveryTimeId;
    }

    public void setDeliveryTimeId(String deliveryTimeId) {
        this.deliveryTimeId = deliveryTimeId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(String deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public String getArayacakAddress() {
        return arayacakAddress;
    }

    public void setArayacakAddress(String arayacakAddress) {
        this.arayacakAddress = arayacakAddress;
    }

    public String getArayacakDeliveryTime() {
        return arayacakDeliveryTime;
    }

    public void setArayacakDeliveryTime(String arayacakDeliveryTime) {
        this.arayacakDeliveryTime = arayacakDeliveryTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PayStatus payStatus) {
        this.payStatus = payStatus;
    }

    public BigDecimal getBalanceOffset() {
        return balanceOffset;
    }

    public void setBalanceOffset(BigDecimal balanceOffset) {
        this.balanceOffset = balanceOffset;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getFreightReduce() {
        return freightReduce;
    }

    public void setFreightReduce(BigDecimal freightReduce) {
        this.freightReduce = freightReduce;
    }

    public BigDecimal getFreightPayable() {
        return freightPayable;
    }

    public void setFreightPayable(BigDecimal freightPayable) {
        this.freightPayable = freightPayable;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getRemarkCustomer() {
        return remarkCustomer;
    }

    public void setRemarkCustomer(String remarkCustomer) {
        this.remarkCustomer = remarkCustomer;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getExchangeOid() {
        return exchangeOid;
    }

    public void setExchangeOid(String exchangeOid) {
        this.exchangeOid = exchangeOid;
    }

    public String getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(String customPrice) {
        this.customPrice = customPrice;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public BigDecimal getCouponReducePrice() {
        return couponReducePrice;
    }

    public void setCouponReducePrice(BigDecimal couponReducePrice) {
        this.couponReducePrice = couponReducePrice;
    }

    //public BigDecimal getCashReducePrice() {
    //    return cashReducePrice;
    //}
    //
    //public void setCashReducePrice(BigDecimal cashReducePrice) {
    //    this.cashReducePrice = cashReducePrice;
    //}

    public BigDecimal getBonusPointReducePrice() {
        return bonusPointReducePrice;
    }

    public void setBonusPointReducePrice(BigDecimal bonusPointReducePrice) {
        this.bonusPointReducePrice = bonusPointReducePrice;
    }

    public boolean isFreeAccountLevel() {
        return isFreeAccountLevel;
    }

    public void setFreeAccountLevel(boolean freeAccountLevel) {
        isFreeAccountLevel = freeAccountLevel;
    }

    public List<OrderProductDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderProductDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
