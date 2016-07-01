package com.cheng.weixin.web.mobile.result;

import java.math.BigDecimal;

/**
 * Desc: 购买信息
 * Author: 光灿
 * Date: 2016/7/1
 */
public class IndexBuy {
    private Long count;
    private BigDecimal price;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}


