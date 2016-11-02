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
    private String conuponId;
    private Boolean isBalance;
    private String remark;

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
        return isBalance;
    }

    public void setBalance(Boolean balance) {
        isBalance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

