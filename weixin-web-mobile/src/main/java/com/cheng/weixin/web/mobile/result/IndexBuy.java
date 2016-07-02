package com.cheng.weixin.web.mobile.result;

import com.cheng.weixin.common.utils.StringFormat;

import java.math.BigDecimal;

/**
 * Desc: 购买信息
 * Author: 光灿
 * Date: 2016/7/1
 */
public class IndexBuy {
    private Long count;
    private String price;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = StringFormat.format(price);
    }
}


