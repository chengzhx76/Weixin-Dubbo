package com.cheng.weixin.rpc.promotion;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 券类型
 * 红包、现金券、免运费券、折扣券、减运费卷
 * Author: cheng
 * Date: 2016/6/17
 */
public class CouponType extends DataEntity<CouponType> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
