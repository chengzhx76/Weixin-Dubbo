package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 账户表
 * Author: cheng
 * Date: 2016/6/3
 */
public class Account extends DataEntity<Account> {
    private int memberId;
    private int accountLevelId;
    private String username;
    private String password;
    private int bonusPointUsable;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(int accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBonusPointUsable() {
        return bonusPointUsable;
    }

    public void setBonusPointUsable(int bonusPointUsable) {
        this.bonusPointUsable = bonusPointUsable;
    }
}
