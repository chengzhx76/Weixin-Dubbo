package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.entity.ProductType;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.result.mall.Mall;
import com.cheng.weixin.web.mobile.result.mall.ProductCategory;
import com.cheng.weixin.web.mobile.result.mall.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Desc: 商城
 * Author: hp
 * Date: 2016/9/9
 */
@Service
public class SysMallService {
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcCartService cartService;

    public List<ProductCategory> getProductCategory() {
        List<ProductType> productTypes = productService.getProductType();

        List<ProductCategory> categories = new ArrayList<>();
        for (ProductType type : productTypes) {
            ProductCategory category = new ProductCategory();
            category.setId(type.getId());
            category.setName(type.getName());
            categories.add(category);
        }
        return categories;
    }

    public Mall getMallProduct(String cid) {
        List<Product> products = productService.getByTypeId(cid);
        Mall mall = new Mall();
        List<Products> mallProducts = new ArrayList<>();
        for (Product product : products) {
            Products mProduct = new Products();
            mProduct.setId(product.getId());
            mProduct.setName(product.getName());
            mProduct.setPrice(StringFormat.format(product.getSalePrice()));
            mProduct.setTag(product.getTag());
            mProduct.setDesc(product.getUnitDesc());

            Picture picture = productService.getDefaultPictureByProductId(product.getId());
            mProduct.setPicLink(picture.getPictureUrl());
            mProduct.setHeight(picture.getHeight());
            mProduct.setWidth(picture.getWidth());
            mallProducts.add(mProduct);
        }
        mall.setProducts(mallProducts);
        mall.setTotalPrice(StringFormat.format(totalPrice("1")));
        return mall;
    }

    /**
     * 购物车商品的总价格
     * @param userId
     * @return
     */
    private BigDecimal totalPrice(String userId) {
        Set<String> productIds =  cartService.getChooseProductIds(userId);
        BigDecimal totalPrice = new BigDecimal(0);
        for (String productId : productIds) {
            Product product = productService.getById(productId);
            if (product.getUnitsInStock() > 0) {
                // 根据Feild获取values 在乘以 单价 = total
                Long counts = cartService.getCounts(userId, productId);
                totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(counts)));
            }
        }
        return totalPrice;
    }

}
