package com.cheng.weixin.service.item.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.item.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    List<Product> loadIndex();
}
