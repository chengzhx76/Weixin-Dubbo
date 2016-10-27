package com.cheng.weixin.service.cart.service;

import com.cheng.weixin.common.constant.Constant;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.cart.entity.CartInfo;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.model.ProductModel;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("cartService")
public class CartService implements RpcCartService {

    @Autowired
    private RpcRedisService redisService;

    @Override
    public Long addProductCount(String userId, String productId) {
        changeChooseStatus(userId, productId);
        return redisService.increase(getCart(userId), getProductFlag(userId, productId));
    }

    @Override
    public Long subProductCount(String userId, String productId) {
        changeChooseStatus(userId, productId);
        return redisService.decrease(getCart(userId), getProductFlag(userId, productId));
    }


    @Override
    public Set<String> getAllProductIds(String userId) {
        return redisService.getFields(getCart(userId));
    }

    @Override
    public Set<String> getChooseProductIds(String userId) {
        Set<String> allProductIds = getAllProductIds(userId);
        Set<String> productIds = new HashSet<>();
        for (String productId : allProductIds) {
            if (productId.startsWith(Constant.CHOOSE)) {
                productIds.add(StringUtils.replace(productId, Constant.CHOOSE, ""));
            }
        }
        return productIds;
    }

    @Override
    public Long getCounts(String userId, String productId) {
        Object counts = redisService.getValueByKeyANdField(getCart(userId), getProductFlag(userId, productId));
        return (Long) counts;
    }

    @Override
    public void deleteProduct(String userId, String productId) {
        redisService.deleteField(getCart(userId), getProductFlag(userId, productId));
    }

    @Override
    public ShoppingCart getShoppingCart(String accessId) {
        Map<Serializable, Object> allProduct = redisService.getEntries(getCart(accessId));
        ShoppingCart shoppingCart = new ShoppingCart();
        if (!allProduct.isEmpty()) {
            List<CartInfo> cartInfos = new ArrayList<>();
            Set<Serializable> fields = allProduct.keySet();
            for (Serializable itemName : fields) {
                CartInfo cart = new CartInfo();
                cart.setAccessId(accessId);
                cart.setProductId(itemName.toString().split("_")[1]);
                cart.setQuantity(Integer.parseInt(allProduct.get(itemName).toString()));
                String isChoose = itemName.toString().split("_")[0];
                cart.setChoose("TRUE".equals(isChoose) ? true : false);
                cartInfos.add(cart);
            }
            shoppingCart.setCartInfos(cartInfos);
            shoppingCart.setAccessId(accessId);
            shoppingCart.setTotalQuantity(cartInfos.size());
        }
        return shoppingCart;
    }

    @Override
    public void addProduct(String userId, String productId, Long count) {
        redisService.put(getCart(userId), getProductFlag(userId, productId), count);
    }

    @Override
    public boolean changeStatus(String userId, String productId) {
        if (redisService.exists(getCart(userId), chooseProduct(productId))) {
            Long counts = (Long) redisService.getValueByKeyANdField(getCart(userId), chooseProduct(productId));
            redisService.deleteField(getCart(userId), chooseProduct(productId));
            redisService.put(getCart(userId), noChooseProduct(productId), counts);
            return false;
        }else if (redisService.exists(getCart(userId), noChooseProduct(productId))) {
            Long counts = (Long) redisService.getValueByKeyANdField(getCart(userId), noChooseProduct(productId));
            redisService.deleteField(getCart(userId),noChooseProduct(productId));
            redisService.put(getCart(userId), chooseProduct(productId), counts);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductModel> getChooseProductInfo(String userId) {
        Map<Serializable, Object> map = redisService.getEntries(getCart(userId));

        List<ProductModel> products = new ArrayList<>();
        Set<Serializable> fields = map.keySet();
        for (Serializable item : fields) {
            if (item.toString().startsWith(Constant.CHOOSE)) {
                ProductModel product = new ProductModel();
                product.setId(StringUtils.remove(item.toString(), Constant.CHOOSE));
                product.setCount(Integer.parseInt(map.get(item).toString()));
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void deletedChooseProduct(String userId) {
        Map<Serializable, Object> map = redisService.getEntries(userId);
        Set<Serializable> fields = map.keySet();
        for (Serializable item : fields) {
            if (redisService.exists(getCart(userId), Constant.CHOOSE+item.toString())) {
                redisService.deleteField(getCart(userId), getProductFlag(getCart(userId), item.toString()));
            }
        }
    }

    @Override
    public void chooseAllProduct(String userId) {
        Set<String> allProductIds = getAllProductIds(userId);
        for (String productId : allProductIds) {
            changeChooseStatus(userId, productId);
        }
    }

    /**
     * 获取当前用户购物车的标识
     * @param userId
     * @return
     */
    private String getCart(String userId) {
        return Constant.CART+userId;
    }

    private String chooseProduct(String productId) {
        return Constant.CHOOSE+productId;
    }
    private String noChooseProduct(String productId) {
        return Constant.NO_CHOOSE+productId;
    }

    private String getProductFlag(String userId, String productId) {
        if (redisService.exists(getCart(userId), chooseProduct(productId))) {
            return chooseProduct(productId);
        }else if (redisService.exists(getCart(userId), noChooseProduct(productId))) {
            return noChooseProduct(productId);
        } else {
            return chooseProduct(productId);
        }
    }

    /**
     * 改变为选择状态
     * @param userId
     * @param productId
     */
    private void changeChooseStatus(String userId, String productId) {
        if (redisService.exists(getCart(userId), noChooseProduct(productId))) {
            Long counts = (Long) redisService.getValueByKeyANdField(getCart(userId), noChooseProduct(productId));
            redisService.deleteField(getCart(userId),noChooseProduct(productId));
            redisService.put(getCart(userId), chooseProduct(productId), counts);
        }
    }
}
