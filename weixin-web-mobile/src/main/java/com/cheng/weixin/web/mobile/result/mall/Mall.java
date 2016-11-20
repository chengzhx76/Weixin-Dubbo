package com.cheng.weixin.web.mobile.result.mall;

import java.util.List;

/**
 * Desc: 商城商品
 * Author: hp
 * Date: 2016/9/9
 */
@Deprecated
public class Mall {
    private List<Products> products;
    private String totalPrice;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
