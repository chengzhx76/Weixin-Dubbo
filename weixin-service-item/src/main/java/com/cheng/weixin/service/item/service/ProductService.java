package com.cheng.weixin.service.item.service;

import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.entity.ProductType;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.service.item.dao.PictureDaoMapper;
import com.cheng.weixin.service.item.dao.ProductDaoMapper;
import com.cheng.weixin.service.item.dao.ProductTypeDaoMapper;
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
    @Autowired
    private ProductTypeDaoMapper productTypeDao;

    @Override
    public Product getById(String id) {
        return productDao.load(new Product(id));
    }

    @Override
    public List<Product> getByTypeId(String typeId) {
        Product product = new Product();
        product.setTypeId(typeId);
        return productDao.loadAll(product);
    }

    @Override
    public Product getDefaultPictureById(String id) {
        Product product = productDao.load(new Product(id));
        Picture pictures = getDefaultPictureByProductId(id);
        product.setDefaultPicture(pictures);
        return product;
    }

    @Override
    public List<Product> getIndex() {
        List<Product> products = productDao.loadAll(new Product(true));
        for (Product product : products) {
            Picture pictures = pictureDao.load(new Picture(product.getId(), true));
            product.setDefaultPicture(pictures);
        }
        return products;
    }

    @Override
    public List<ProductType> getProductType() {
        return productTypeDao.loadAll();
    }

    @Override
    public List<Picture> getAllPicture(String productId) {
        return pictureDao.loadAll(new Picture(productId, null));
    }

    @Override
    public Picture getDefaultPictureByProductId(String productId) {
        Picture picture = pictureDao.load(new Picture(productId, true));
        return picture;
    }

    @Override
    public List<Picture> getShowPictureByProductId(String productId) {
        return pictureDao.loadAll(new Picture(productId, false));
    }
}
