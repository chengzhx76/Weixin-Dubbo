package com.cheng.weixin.web.mobile.result.product;

import com.cheng.weixin.web.mobile.result.comment.ProductComment;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

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
    private int sellNum; // 月销
    private int good; // 好评
    private String sellPrice;
    private String marketPrice;
    private int giveAway;

    private List<ProductPic> picList;

    private List<ProductComment> comments;

    public List<ProductComment> getComments() {
        return comments;
    }

    public void setComments(List<ProductComment> comments) {
        this.comments = comments;
    }

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

    public int getGiveAway() {
        return giveAway;
    }

    public void setGiveAway(int giveAway) {
        this.giveAway = giveAway;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
