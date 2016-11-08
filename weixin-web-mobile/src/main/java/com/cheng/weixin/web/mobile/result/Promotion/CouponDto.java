package com.cheng.weixin.web.mobile.result.Promotion;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/7
 */
public class CouponDto {
    private String couponId;
    private String title;
    private String faceValue;
    private String enoughMoney;
    private String beginTime;
    private String endTime;
    private boolean usable;

    public CouponDto() {
    }

    public CouponDto(String title, String faceValue, String enoughMoney, String beginTime, String endTime) {
        this.title = title;
        this.faceValue = faceValue;
        this.enoughMoney = enoughMoney;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getEnoughMoney() {
        return enoughMoney;
    }

    public void setEnoughMoney(String enoughMoney) {
        this.enoughMoney = enoughMoney;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }
}
