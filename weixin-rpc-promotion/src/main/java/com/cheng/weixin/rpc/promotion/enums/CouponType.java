package com.cheng.weixin.rpc.promotion.enums;

/**
 * Desc: 券类型
 * 红包、现金券、免运费券、折扣券
 * Author: cheng
 * Date: 2016/6/17
 */
public enum CouponType {


    LUCKYMONEY("红包券"),      // 只有红包券才是满减券-- 红包券不需要指定商品ID || 现在只完成了一个
    FREE_SHIPPING("免运费券"),
    CASH("现金券"),
    DISCOUNT("折扣券");
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
