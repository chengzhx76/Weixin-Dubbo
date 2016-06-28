package com.cheng.weixin.web.mobile.result;

import java.math.BigDecimal;
import java.util.List;

/**
 * Desc: 首页信息
 * Author: cheng
 * Date: 2016/6/28
 */
public class Index {
    private List<IndexProduct> products;
    private BigDecimal totalPirce;

    public List<IndexProduct> getProducts() {
        return products;
    }

    public void setProducts(List<IndexProduct> products) {
        this.products = products;
    }

    public BigDecimal getTotalPirce() {
        return totalPirce;
    }

    public void setTotalPirce(BigDecimal totalPirce) {
        this.totalPirce = totalPirce;
    }
}
