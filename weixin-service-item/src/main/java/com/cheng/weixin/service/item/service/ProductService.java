package com.cheng.weixin.service.item.service;

import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.service.item.dao.PictureDaoMapper;
import com.cheng.weixin.service.item.dao.ProductDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("productService")
public class ProductService implements RpcProductService {
    @Autowired
    private ProductDaoMapper productDao;
    @Autowired
    private PictureDaoMapper pictureDao;

    /**
     * 根据ID获取商品
     * @param id
     * @return
     */
    @Override
    public Product getById(String id) {
        return productDao.load(new Product(id));
    }

    @Override
    public Product getDefaultPictureById(String id) {
        Product product = productDao.load(new Product(id));
        Picture pictures = pictureDao.loadDefaultPicture(new Picture(product.getId()));
        product.setDefaultPicture(pictures);
        return product;
    }

    @Override
    public List<Product> getIndex() {
        List<Product> products = productDao.loadIndex();
        for (Product product : products) {
            Picture pictures = pictureDao.loadDefaultPicture(new Picture(product.getId()));
            product.setDefaultPicture(pictures);
        }
        return products;
    }



}
