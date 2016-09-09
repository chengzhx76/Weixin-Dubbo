package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rpc.order.enumType.OrderType;
import com.cheng.weixin.rpc.order.enumType.PayStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Desc: 订单
 * Author: cheng
 * Date: 2016/6/6
 */
public class OrderInfo extends DataEntity<OrderInfo> {
    private int accountId;
    private int relateOid;
    private BigDecimal amountPayable;
    private BigDecimal amountPaid;
    private BigDecimal salePriceTotal;
    private String consignee;
    private String mobile;
    private String address;
    private int deliveryTimeId;
    private int payId;
    private int deliveryTypeId;
    private String arayacakAddress;
    private String arayacakDeliveryTimeId;
    private String province;
    private String city;
    private String country;
    private PayStatus payStatus;
    private int orderStatusCustomerId;
    private int orderStatusSystemId;
    private OrderType orderType;
    private BigDecimal freightReduce;
    private BigDecimal freightPayable;
    private BigDecimal productTotalPrice;
    private BigDecimal discount;
    private String remarkSystem;
    private String postCode;
    private String telephone;
    private String email;
    private Date payTime;
    private String exchangeOid;
    private String customPice;
    private String couponCode;
    private BigDecimal couponReducePrice;
    private BigDecimal cashReducePrice;
    private BigDecimal bonusPointReducePrice;
    private boolean isFreeAccountLevel;

    public String getArayacakAddress() {
        return arayacakAddress;
    }

    public OrderInfo setArayacakAddress(String arayacakAddress) {
        this.arayacakAddress = arayacakAddress;
        return this;
    }

    public String getArayacakDeliveryTimeId() {
        return arayacakDeliveryTimeId;
    }

    public OrderInfo setArayacakDeliveryTimeId(String arayacakDeliveryTimeId) {
        this.arayacakDeliveryTimeId = arayacakDeliveryTimeId;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRelateOid() {
        return relateOid;
    }

    public void setRelateOid(int relateOid) {
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

    public BigDecimal getSalePriceTotal() {
        return salePriceTotal;
    }

    public void setSalePriceTotal(BigDecimal salePriceTotal) {
        this.salePriceTotal = salePriceTotal;
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

    public int getDeliveryTimeId() {
        return deliveryTimeId;
    }

    public void setDeliveryTimeId(int deliveryTimeId) {
        this.deliveryTimeId = deliveryTimeId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(int deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
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

    public int getOrderStatusCustomerId() {
        return orderStatusCustomerId;
    }

    public void setOrderStatusCustomerId(int orderStatusCustomerId) {
        this.orderStatusCustomerId = orderStatusCustomerId;
    }

    public int getOrderStatusSystemId() {
        return orderStatusSystemId;
    }

    public void setOrderStatusSystemId(int orderStatusSystemId) {
        this.orderStatusSystemId = orderStatusSystemId;
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

    public String getRemarkSystem() {
        return remarkSystem;
    }

    public void setRemarkSystem(String remarkSystem) {
        this.remarkSystem = remarkSystem;
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

    public String getCustomPice() {
        return customPice;
    }

    public void setCustomPice(String customPice) {
        this.customPice = customPice;
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

    public BigDecimal getCashReducePrice() {
        return cashReducePrice;
    }

    public void setCashReducePrice(BigDecimal cashReducePrice) {
        this.cashReducePrice = cashReducePrice;
    }

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
}
