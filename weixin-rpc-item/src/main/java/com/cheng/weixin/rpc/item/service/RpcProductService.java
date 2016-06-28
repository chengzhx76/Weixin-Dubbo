package com.cheng.weixin.rpc.item.service;

import com.cheng.weixin.rpc.item.entity.Product;

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

}
