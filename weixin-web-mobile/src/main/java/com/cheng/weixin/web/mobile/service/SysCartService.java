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
                    if (cartInfo.isChoose()) {
                        totalPrice = totalPrice.add(salePrice);
                    }
                    productInfo.setSalePrice(StringFormat.format(salePrice));
                    productInfo.setMarketPrice(StringFormat.format(product.getMarketPrice()));
                    productInfo.setName(product.getName());
                    productInfo.setNums(cartInfo.getQuantity());
                    productInfo.setChoose(cartInfo.isChoose());
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
        // 获取该商品的数量
        Long currentCount = cartService.addProductCount(userId, id);
        return chooseShoppingCartPrice(userId, currentCount);
    }

    public ProductCartInfo subProduct(String userId, String id) {
        // 获取该商品的数量
        Long currentCount = cartService.subProductCount(userId, id);
        //if (currentCount <= 0) {
        //    cartService.deleteProduct(userId, id);
        //    currentCount = 0L;
        //}
        return chooseShoppingCartPrice(userId, currentCount);
    }

    public ProductCartInfo deleteProduct(String userId, String id) {
        cartService.deleteProduct(userId, id);
        return chooseShoppingCartPrice(userId, null);
    }

/*    public ProductCartInfo batchAddProduct(String userId, List<ProductDto> products) {
        for (ProductDto product : products) {
            cartService.addProduct(userId, product.getProductId(), product.getCount());
        }

        // 购物车已选择的商品的总价格
        BigDecimal totalPrice = new BigDecimal(0);
        Set<String> productIds = cartService.getChooseProductIds(userId);
        for (String productId : productIds) {
            Long count = cartService.getCounts(userId, productId);
            Product product = productService.getById(productId);
            totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
        }
        ProductCartInfo productCart = new ProductCartInfo();
        productCart.setCount(0);
        productCart.setTotalPrice(StringFormat.format(totalPrice));
        productCart.setFreight("2");
        return productCart;
    }*/

    /**
     * 购物车已选择的商品的总价格
     * @param userId
     * @param currentCount
     * @return
     */
    private ProductCartInfo chooseShoppingCartPrice(String userId, Long currentCount) {
        BigDecimal totalPrice = new BigDecimal(0);
        Set<String> productIds = cartService.getChooseProductIds(userId);
        for (String productId : productIds) {
            Long count = cartService.getCounts(userId, productId);
            Product product = productService.getById(productId);
            totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
        }
        ProductCartInfo productCart = new ProductCartInfo();
        if (currentCount != null)
            productCart.setCount(Integer.parseInt(currentCount+""));
        productCart.setTotalPrice(StringFormat.format(totalPrice));
        productCart.setFreight("2");
        return productCart;
    }

}
