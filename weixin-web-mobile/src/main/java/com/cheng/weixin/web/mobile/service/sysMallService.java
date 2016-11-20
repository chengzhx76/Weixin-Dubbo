package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.entity.ProductType;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.exception.ProductException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.result.mall.ProductCategory;
import com.cheng.weixin.web.mobile.result.mall.Products;
import com.cheng.weixin.web.mobile.security.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // TODO 登陆后查看该商品已买了多少
    public List<Products> getMallProduct(String cid) {
        List<Product> products = productService.getByTypeId(cid);
        //Mall mall = new Mall();
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
        //mall.setProducts(mallProducts);
        //mall.setTotalPrice(StringFormat.format(totalPrice(LocalUser.getUser().getUserId())));
        return mallProducts;
    }


    /**
     * 购买商品
     * @param productId
     * @return
     */
    public long addProduct(String productId) {
        Product product = productService.getById(productId);
        if (product.getUnitsInStock()<=0) {
            throw new ProductException(StatusCode.PRODUCT_STOCK_SHORTAGE);
        }
        long count = cartService.addProductCount(LocalUser.getUser().getUserId(), productId);
        // 金额
        //BigDecimal totalPrice = totalPrice("1");

        //MallBuy buy = new MallBuy();
        //buy.setCount(count);
        //buy.setTotalPrice(totalPrice);
        return count;
    }
    /**
     * 减少商品
     * @param productId
     * @return
     */
    public long subProduct(String productId) {
        long count = cartService.subProductCount(LocalUser.getUser().getUserId(), productId);
        // 金额
        //BigDecimal totalPrice = totalPrice("1");
        //MallBuy buy = new MallBuy();
        //buy.setCount(count);
        //buy.setTotalPrice(totalPrice);
        return count;
    }

}
