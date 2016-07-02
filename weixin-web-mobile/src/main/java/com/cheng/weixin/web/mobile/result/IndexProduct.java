package com.cheng.weixin.web.mobile.result;

import com.cheng.weixin.common.utils.StringFormat;

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
    private int width;
    private int height;
    private String tag;
    private String desc;

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
        this.price = StringFormat.format(price);
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
