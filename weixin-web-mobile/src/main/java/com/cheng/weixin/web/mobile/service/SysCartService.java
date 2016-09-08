package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.entity.CartInfo;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.result.cart.ProductCartInfo;
import com.cheng.weixin.web.mobile.result.cart.ProductInfo;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Desc: 购物车
 * Author: hp
 * Date: 2016/8/26
 */
@Service("sysSartService")
public class SysCartService {
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
        if (null != cartInfos && !cartInfos.isEmpty()) {
            BigDecimal totalPrice = new BigDecimal(0);
            for (CartInfo cartInfo : cartInfos) {
                productInfo = new ProductInfo();
                Product product = productService.getDefaultPictureById(cartInfo.getProductId());
                if (null != product) {
                    productInfo.setProductImg(product.getDefaultPicture().getPictureUrl());
                    BigDecimal salePrice = product.getSalePrice();
                    //totalPrice = totalPrice.add(salePrice);
                    productInfo.setSalePrice(StringFormat.format(salePrice));
                    productInfo.setMarketPrice(StringFormat.format(product.getMarketPrice()));
                    productInfo.setName(product.getName());
                    productInfo.setNums(cartInfo.getQuantity());
                    productInfos.add(productInfo);
                }
            }
            shoppingCartInfo.setProducts(productInfos);
            shoppingCartInfo.setDeliveryDate(new DateTime().plusDays(1).toString("MM月dd日"));
            shoppingCartInfo.setTotalPrice(StringFormat.format(totalPrice));
        }
        return shoppingCartInfo;
    }

    public ProductCartInfo addProduct(String userId, String id) {
        // 先获取该商品的数量
        Long currentCount = cartService.addProductCount(userId, id);

        // 购物车已选择的商品的总价格
        BigDecimal totalPrice = new BigDecimal(0);
        Set<String> productIds = cartService.getProductIds(userId);
        for (String productId : productIds) {
            Long count = cartService.getCounts(userId, productId);
            Product product = productService.getById(productId);
            totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
        }
        ProductCartInfo productCart = new ProductCartInfo();
        productCart.setCount(Integer.parseInt(currentCount+""));
        productCart.setTotalPrice(StringFormat.format(totalPrice));
        productCart.setFreight("2");
        return productCart;
    }

    public ProductCartInfo subProduct(String userId, String id) {
        // 先获取该商品的数量
        Long currentCount = cartService.subProductCount(userId, id);

        // 购物车已选择的商品的总价格
        BigDecimal totalPrice = new BigDecimal(0);
        Set<String> productIds = cartService.getProductIds(userId);
        for (String productId : productIds) {
            Long count = cartService.getCounts(userId, productId);
            Product product = productService.getById(productId);
            totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
        }
        ProductCartInfo productCart = new ProductCartInfo();
        productCart.setCount(Integer.parseInt(currentCount+""));
        productCart.setTotalPrice(StringFormat.format(totalPrice));
        productCart.setFreight("2");
        return productCart;
    }

}
