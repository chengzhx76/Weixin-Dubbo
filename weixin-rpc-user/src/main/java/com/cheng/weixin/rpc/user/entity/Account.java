package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rpc.user.enumType.Credit;
import com.cheng.weixin.rpc.user.enumType.SourceFrom;

import java.math.BigDecimal;

/**
 * Desc: 账户表
 * Author: cheng
 * Date: 2016/6/3
 */
public class Account extends DataEntity<Account> {
    private String accountLevelId;
    private Credit credit;
    private String username;
    private String password;
    private int bonusPointUsable;
    private int bonusPointUpgrade;
    private BigDecimal balance;
    private boolean isEmployee;
    private String ip;
    private SourceFrom sourceFrom;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    //public Account(String id, String loginIp) {
    //    super.id = id;
    //    this.username = loginIp;
    //}


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

    public String getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(String accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
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

    public SourceFrom getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(SourceFrom sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}
