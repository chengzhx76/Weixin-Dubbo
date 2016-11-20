package com.cheng.weixin.web.mobile.result.user;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

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
    private int accountLevel;
    private int bonusPointRecord;
    private int bonusPointUpgrade;
    private String balance;
    private String couponRecord;
    private int currentMonthBonusPoint;

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

    public int getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(int accountLevel) {
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

    public int getCurrentMonthBonusPoint() {
        return currentMonthBonusPoint;
    }

    public void setCurrentMonthBonusPoint(int currentMonthBonusPoint) {
        this.currentMonthBonusPoint = currentMonthBonusPoint;
    }

    public int getBonusPointUpgrade() {
        return bonusPointUpgrade;
    }

    public void setBonusPointUpgrade(int bonusPointUpgrade) {
        this.bonusPointUpgrade = bonusPointUpgrade;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
