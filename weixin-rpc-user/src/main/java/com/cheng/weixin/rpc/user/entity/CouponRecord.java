package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 记录券的收支情况
 * Author: cheng
 * Date: 2016/6/3
 */
public class CouponRecord extends DataEntity<CouponRecord> {
    private int accountId;
    private int couponCodeId;
    private int txType;
    private int behaviorId;
    private String txResult;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCouponCodeId() {
        return couponCodeId;
    }

    public void setCouponCodeId(int couponCodeId) {
        this.couponCodeId = couponCodeId;
    }

    public int getTxType() {
        return txType;
    }

    public void setTxType(int txType) {
        this.txType = txType;
    }

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    public String getTxResult() {
        return txResult;
    }

    public void setTxResult(String txResult) {
        this.txResult = txResult;
    }
}
