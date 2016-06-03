package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 记录积分等级的规则
 *       积分等级与QQ上的星星月亮太阳升级规则一样，四个红蜜蜂可升级成一个黄蜜蜂，四个黄蜜蜂可升级成一个蓝蜜蜂
 * Author: cheng
 * Date: 2016/6/3
 */
public class AccountLevel extends DataEntity<AccountLevel> {
    private int accountId;
    private int level;
    private int needRonusPoint;
    private int totalRonusPoint;
    private double reductPercent;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNeedRonusPoint() {
        return needRonusPoint;
    }

    public void setNeedRonusPoint(int needRonusPoint) {
        this.needRonusPoint = needRonusPoint;
    }

    public int getTotalRonusPoint() {
        return totalRonusPoint;
    }

    public void setTotalRonusPoint(int totalRonusPoint) {
        this.totalRonusPoint = totalRonusPoint;
    }

    public double getReductPercent() {
        return reductPercent;
    }

    public void setReductPercent(double reductPercent) {
        this.reductPercent = reductPercent;
    }
}
