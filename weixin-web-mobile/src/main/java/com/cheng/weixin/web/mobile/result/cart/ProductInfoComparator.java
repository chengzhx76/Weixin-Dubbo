package com.cheng.weixin.web.mobile.result.cart;

import java.util.Comparator;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/13
 */
public class ProductInfoComparator implements Comparator<ProductInfo> {
    @Override
    public int compare(ProductInfo product1, ProductInfo product2) {
        if (product1.isStock()==product2.isStock()) {
            return 0;
        }else if (product1.isStock()) {
            return -1;
        }else {
            return 1;
        }
    }
}
