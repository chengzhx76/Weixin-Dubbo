package com.cheng.weixin.web.mobile.param;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    public static void main(String[] args) throws UnsupportedEncodingException {

        String[] productIds = {"1", "2"};
        ProductDto p = new ProductDto();
        p.setProductIds(productIds);
        String data = JSON.toJSONString(productIds);
        String ecode = URLEncoder.encode(data, "UTF-8");
        System.out.println(data + " == "+ecode);
    }

}
