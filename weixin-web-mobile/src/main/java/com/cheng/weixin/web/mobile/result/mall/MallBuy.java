package com.cheng.weixin.web.mobile.result.mall;

import com.cheng.weixin.common.utils.StringFormat;

import java.math.BigDecimal;

/**
 * Desc: 购买信息
 * Author: 光灿
 * Date: 2016/7/1
 */
@Deprecated
public class MallBuy {
    private Long count;
    private String totalPrice;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = StringFormat.format(totalPrice);
    }
}


