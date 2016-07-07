package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 记录现金账户的收支情况
 * Author: cheng
 * Date: 2016/6/3
 */
public class CashRecord extends DataEntity<CashRecord> {
    private int accountId;
    private int beforeMoney;
    private int txMoney;
    private int frozenMoney;
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

    public int getBeforeMoney() {
        return beforeMoney;
    }

    public void setBeforeMoney(int beforeMoney) {
        this.beforeMoney = beforeMoney;
    }

    public int getTxMoney() {
        return txMoney;
    }

    public void setTxMoney(int txMoney) {
        this.txMoney = txMoney;
    }

    public int getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(int frozenMoney) {
        this.frozenMoney = frozenMoney;
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
