package com.cheng.weixin.web.mobile.result.product;

import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/8
 */
public class ProductDetail {

    private String productId;
    private String name;
    private String desc;
    private int sellNum;
    private int good;
    private String sellPrice;
    private String marketPrice;

    private List<ProductPic> picList;

    public List<ProductPic> getPicList() {
        return picList;
    }

    public void setPicList(List<ProductPic> picList) {
        this.picList = picList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
}
