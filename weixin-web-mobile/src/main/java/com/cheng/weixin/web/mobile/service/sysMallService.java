package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.entity.ProductType;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.result.mall.MallProduct;
import com.cheng.weixin.web.mobile.result.mall.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 商城
 * Author: hp
 * Date: 2016/9/9
 */
@Service("sysMallService")
public class SysMallService {
    @Autowired
    private RpcProductService productService;

    public List<ProductCategory> getProductCategory() {
        List<ProductType> productTypes = productService.getProductType();

        List<ProductCategory> categories = new ArrayList<>();
        for (ProductType type : productTypes) {
            ProductCategory category = new ProductCategory();
            category.setId(type.getId());
            category.setName(category.getName());
        }
        return categories;
    }

    public List<MallProduct> getMallProduct(String cid) {
        List<Product> products = productService.getByTypeId(cid);

        List<MallProduct> mallProducts = new ArrayList<>();
        for (Product product : products) {
            MallProduct mallProduct = new MallProduct();
            mallProduct.setId(product.getId());
            mallProduct.setName(product.getName());
            mallProduct.setPrice(StringFormat.format(product.getSalePrice()));
            mallProduct.setTag(product.getTag());

            Picture picture = productService.getDefaultPictureByProductId(product.getId());
            mallProduct.setPicLink(picture.getPictureUrl());
            mallProduct.setHeight(picture.getHeight());
            mallProduct.setWidth(picture.getWidth());
            mallProducts.add(mallProduct);
        }
        return mallProducts;
    }

}
