package com.cheng.weixin.rpc.promotion.enums;

/**
 * Desc: 券类型
 * 红包、现金券、免运费券、折扣券、减运费卷
 * Author: cheng
 * Date: 2016/6/17
 */
public enum CouponType {

    LUCKYMONEY("红包券"),
    CASH("现金券"),
    FREE_SHIPPING("免运费券"),
    DISCOUNT("折扣券"),
    REDUCED_FREIGHT("减运费卷");

    private String name;
    CouponType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
