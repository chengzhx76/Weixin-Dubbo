package com.cheng.weixin.web.mobile.result.index;

import com.cheng.weixin.common.utils.StringFormat;

import java.math.BigDecimal;
import java.util.List;

/**
 * Desc: 首页信息
 * Author: cheng
 * Date: 2016/6/28
 */
public class Index {
    private List<IndexAd> ads;
    private List<IndexNotice> notices;
    private List<IndexProduct> products;
    private String totalPirce;

    public List<IndexAd> getAds() {
        return ads;
    }

    public void setAds(List<IndexAd> ads) {
        this.ads = ads;
    }

    public List<IndexNotice> getNotices() {
        return notices;
    }

    public void setNotices(List<IndexNotice> notices) {
        this.notices = notices;
    }

    public void setTotalPirce(String totalPirce) {
        this.totalPirce = totalPirce;
    }

    public List<IndexProduct> getProducts() {
        return products;
    }

    public void setProducts(List<IndexProduct> products) {
        this.products = products;
    }

    public String getTotalPirce() {
        return totalPirce;
    }

    public void setTotalPirce(BigDecimal totalPirce) {
        this.totalPirce = StringFormat.format(totalPirce);
    }
}
