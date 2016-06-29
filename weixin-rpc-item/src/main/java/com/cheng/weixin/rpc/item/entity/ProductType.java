package com.cheng.weixin.rpc.item.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 商品类型
 * Author: cheng
 * Date: 2016/6/6
 */
public class ProductType extends DataEntity<ProductType> {
    private String name;

    public ProductType() {}

    public ProductType(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
