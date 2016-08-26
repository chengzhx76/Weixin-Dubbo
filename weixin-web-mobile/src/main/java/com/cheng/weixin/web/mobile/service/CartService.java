package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.entity.CartInfo;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.result.cart.ProductInfo;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 购物车
 * Author: hp
 * Date: 2016/8/26
 */
@Service("cartService")
public class CartService {
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    public ShoppingCartInfo getShoppingCart(String userId) {
        ShoppingCart shoppingCart = cartService.getShoppingCart(userId);
        List<CartInfo> cartInfos = shoppingCart.getCartInfos();

        ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
        List<ProductInfo> productInfos = new ArrayList<>();
        ProductInfo productInfo = null;
        if (!cartInfos.isEmpty()) {
            for (CartInfo cartInfo : cartInfos) {
                productInfo = new ProductInfo();
                Product product = productService.getDefaultPictureById(cartInfo.getProductId());
                if (null != product) {
                    productInfo.setProductImg(product.getDefaultPicture().getPictureUrl());
                    productInfo.setSalePrice(StringFormat.format(product.getSalePrice()));
                    productInfo.setMarketPrice(StringFormat.format(product.getMarketPrice()));
                    productInfo.setName(product.getName());
                    productInfo.setNums(cartInfo.getQuantity());
                    productInfos.add(productInfo);
                }
            }
            shoppingCartInfo.setProducts(productInfos);
        }
        return shoppingCartInfo;
    }

}
