package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

import java.math.BigDecimal;

/**
 * Desc: 账户表
 * Author: cheng
 * Date: 2016/6/3
 */
public class Account extends DataEntity<Account> {
    private int memberId;
    private int accountLevelId;
    private int creditLevelId;
    private String username;
    private String password;
    private int bonusPointUsable;
    private int bonusPointUpgrade;
    private BigDecimal balance;
    private boolean isEmployee;
    private String ip;
    private String sourceFrom;

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

    public int getCreditLevelId() {
        return creditLevelId;
    }

    public void setCreditLevelId(int creditLevelId) {
        this.creditLevelId = creditLevelId;
    }

    public int getBonusPointUsable() {
        return bonusPointUsable;
    }

    public void setBonusPointUsable(int bonusPointUsable) {
        this.bonusPointUsable = bonusPointUsable;
    }

    public int getBonusPointUpgrade() {
        return bonusPointUpgrade;
    }

    public void setBonusPointUpgrade(int bonusPointUpgrade) {
        this.bonusPointUpgrade = bonusPointUpgrade;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}
