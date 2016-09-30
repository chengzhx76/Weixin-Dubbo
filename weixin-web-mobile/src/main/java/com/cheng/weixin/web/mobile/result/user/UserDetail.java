package com.cheng.weixin.web.mobile.result.user;

/**
 * Desc:
 * Author: hp
 * Date: 2016/9/30
 */
public class UserDetail {
    private String id;
    private String avatar;
    private String nickname;
    private String username;
    private String accountLevel;
    private int bonusPointRecord;
    private String balance;
    private String couponRecord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public int getBonusPointRecord() {
        return bonusPointRecord;
    }

    public void setBonusPointRecord(int bonusPointRecord) {
        this.bonusPointRecord = bonusPointRecord;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCouponRecord() {
        return couponRecord;
    }

    public void setCouponRecord(String couponRecord) {
        this.couponRecord = couponRecord;
    }
}
