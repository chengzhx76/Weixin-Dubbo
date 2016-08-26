package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 积分记录  记录积分的收支情况
 * Author: cheng
 * Date: 2016/6/3
 */
public class BonusPointRecord extends DataEntity<BonusPointRecord> {
    private int accountId;
    private int beforeBonusPoints;
    private int txBonusPoints;
    private int frozenBonusPoints;
    private int afterBonusPoints;
    private int txType;
    private int behaviorId;
    private String txResult;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBeforeBonusPoints() {
        return beforeBonusPoints;
    }

    public void setBeforeBonusPoints(int beforeBonusPoints) {
        this.beforeBonusPoints = beforeBonusPoints;
    }

    public int getTxBonusPoints() {
        return txBonusPoints;
    }

    public void setTxBonusPoints(int txBonusPoints) {
        this.txBonusPoints = txBonusPoints;
    }

    public int getFrozenBonusPoints() {
        return frozenBonusPoints;
    }

    public void setFrozenBonusPoints(int frozenBonusPoints) {
        this.frozenBonusPoints = frozenBonusPoints;
    }

    public int getAfterBonusPoints() {
        return afterBonusPoints;
    }

    public void setAfterBonusPoints(int afterBonusPoints) {
        this.afterBonusPoints = afterBonusPoints;
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
