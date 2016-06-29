package com.cheng.weixin.rpc.item.entity;

import com.cheng.common.entity.DataEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/6/6
 */
public class Product extends DataEntity<Product> {
    private String name;
    private BigDecimal marketPrice;
    private BigDecimal salePrice;
    private String no;
    private String keywords;
    private int productTypeId;
    private boolean isAlive;
    private int modifyAdminId;
    private boolean isIndex;

    private List<Picture> pictures;



    public Product() {}

    public Product(String id) {
        super();
        this.id = id;
    }
    public Product(String id, boolean isIndex) {
        super();
        this.id = id;
        this.isIndex = isIndex;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getModifyAdminId() {
        return modifyAdminId;
    }

    public void setModifyAdminId(int modifyAdminId) {
        this.modifyAdminId = modifyAdminId;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
