package com.cheng.weixin.rpc.item.service;

import com.cheng.weixin.rpc.item.entity.Product;

import java.util.List;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/6/28
 */
public interface RpcProductService {

    /**
     * 根据ID获取商品
     * @param id
     * @return
     */
    Product getById(String id);
    /**
     * 根据ID获取商品和默认图片
     * @param id
     * @return
     */
    Product getDefaultPictureById(String id);

    /**
     * 获取首页的商品
     * @return
     */
    List<Product> getIndex();

}
