package com.cheng.weixin.service.cart.service;

import com.cheng.weixin.rpc.cart.entity.CartInfo;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("cartService")
public class CartService implements RpcCartService {

    private static final String CART = "CART_";

    @Autowired
    private RpcRedisService redisService;

    ///**
    // * 增加商品的数量
    // *
    // * @param productId
    // * @param count
    // */
    //@Override
    //public void addProductCount(String userId, String productId, Integer count) {
    //    boolean exists = redisService.exists(getCart(userId), productId);
    //    if (exists) {
    //        redisService.add(getCart(userId), productId, String.valueOf(count));
    //    }else {
    //        redisService.add(getCart(userId), productId, null);
    //    }
    //}

    /**
     * 递增商品的数量
     * @param userId
     * @param productId
     * @return 增加后的商品数量
     */
    @Override
    public Long addProductCount(String userId, String productId) {
        return redisService.increase(getCart(userId), productId);
    }
    /**
     * 减少商品数量
     * @param userId
     * @param productId
     * @return 减少后的商品数量
     */
    @Override
    public Long subProductCount(String userId, String productId) {
        return redisService.decrease(getCart(userId), productId);
    }

    /**
     * 获取购物车中所有商品的ID
     *
     * @param userId
     * @return
     */
    @Override
    public Set<String> getProductIds(String userId) {
        return redisService.getFields(getCart(userId));
    }

    @Override
    public Long getCounts(String userId, String productId) {
        Object counts = redisService.getValueByKeyANdField(getCart(userId), productId);
        return (Long) counts;
    }

    @Override
    public void deleteProduct(String userId, String productId) {
        redisService.deleteField(userId, productId);
    }

    /**
     * 获取当前用户购物车的标识
     * @param userId
     * @return
     */
    private String getCart(String userId) {
        return CART+userId;
    }

    @Override
    public ShoppingCart getShoppingCart(String accessId) {
        Map<Serializable, Object> allProduct = redisService.getEntries(accessId);

        ShoppingCart shoppingCart = new ShoppingCart();
        if (!allProduct.isEmpty()) {
            List<CartInfo> cartInfos = new ArrayList<>();
            Set<Serializable> fields = allProduct.keySet();
            for (Serializable itemName : fields) {
                cartInfos.add(new CartInfo(accessId, itemName.toString(), Integer.parseInt(allProduct.get(itemName).toString())));
                System.out.println("===> "+itemName+" "+allProduct.get(itemName));
            }
            shoppingCart.setCartInfos(cartInfos);
            shoppingCart.setAccessId(accessId);
            shoppingCart.setTotalQuantity(cartInfos.size());
        }
        return shoppingCart;
    }
}
