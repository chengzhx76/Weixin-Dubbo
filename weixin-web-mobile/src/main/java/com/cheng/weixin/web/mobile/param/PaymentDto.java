package com.cheng.weixin.web.mobile.param;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Desc: 付款页面
 * Author: hp
 * Date: 2016/11/2
 */
public class PaymentDto {

    private String addrId;
    private String timeId;
    private String payId;
    private String conuponId;
    private Boolean balance; // 是否使用了余额
    private String remark;
    private Boolean since; // 是否是自提

    private String ticketId; // 优惠券

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getConuponId() {
        return conuponId;
    }

    public void setConuponId(String conuponId) {
        this.conuponId = conuponId;
    }

    public Boolean getBalance() {
        return balance;
    }

    public void setBalance(Boolean balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getSince() {
        return since;
    }

    public void setSince(Boolean since) {
        this.since = since;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("addrId", addrId)
                .append("timeId", timeId)
                .append("payId", payId)
                .append("conuponId", conuponId)
                .append("balance", balance)
                .append("remark", remark)
                .append("since", since)
                .append("ticketId", ticketId)
                .toString();
    }
}

