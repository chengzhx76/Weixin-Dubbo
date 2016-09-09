package com.cheng.weixin.web.mobile.param;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/7/4
 */
public class ProductDto {
    private String productId;
    private Long count;

    private String[] productIds;

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
