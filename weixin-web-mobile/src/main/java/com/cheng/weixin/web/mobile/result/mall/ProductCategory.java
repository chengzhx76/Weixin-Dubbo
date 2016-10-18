package com.cheng.weixin.web.mobile.result.mall;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Desc: 商品类别
 * Author: hp
 * Date: 2016/9/9
 */
public class ProductCategory {
    private String id;
    private String name;

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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
