package com.cheng.weixin.service.item.service;

import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.service.item.dao.ProductDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("productService")
public class ProductService implements RpcProductService {
    @Autowired
    private ProductDaoMapper productDao;

    /**
     * 根据ID获取商品
     * @param id
     * @return
     */
    @Override
    public Product getById(String id) {
        return productDao.load(new Product(id));
    }
}
