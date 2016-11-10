package com.cheng.weixin.web.mobile.param;

/**
 * Desc: 付款页面
 * Author: hp
 * Date: 2016/11/2
 */
public class PaymentDto {

    private String addrId;
    private String timeId;
    private String payId;
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
}

