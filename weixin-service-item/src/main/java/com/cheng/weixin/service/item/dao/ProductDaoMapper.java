package com.cheng.weixin.service.item.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.item.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/6/28
 */
@Repository
public interface ProductDaoMapper extends BaseDaoMapper<Product> {
    /**
     * 获取首页的商品
     * @return
     */
    //List<Product> loadIndex();

    /**
     * 获取商品 根据类型ID
     * @param product
     * @return
     */
    //List<Product> loadMallByTypeId(Product product);
}
