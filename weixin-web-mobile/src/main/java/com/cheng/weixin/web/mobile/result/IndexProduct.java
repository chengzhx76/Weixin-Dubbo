package com.cheng.weixin.web.mobile.result;

import com.cheng.weixin.common.utils.BigDecimalFormat;

import java.math.BigDecimal;

/**
 * Desc: 首页商品信息
 * Author: cheng
 * Date: 2016/6/28
 */
public class IndexProduct {
    private String id;
    private String name;
    private String price;
    private String picLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = BigDecimalFormat.format(price);
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }
}
