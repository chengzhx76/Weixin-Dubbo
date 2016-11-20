package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.entity.CartInfo;
import com.cheng.weixin.rpc.cart.entity.ShoppingCart;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.order.entity.ArayacakAddress;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.rpc.user.entity.DeliveryAddress;
import com.cheng.weixin.rpc.user.entity.Member;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.exception.ProductException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.param.AddressDto;
import com.cheng.weixin.web.mobile.result.cart.ProductCartInfo;
import com.cheng.weixin.web.mobile.result.cart.ProductInfo;
import com.cheng.weixin.web.mobile.result.cart.ProductInfoComparator;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import com.cheng.weixin.web.mobile.security.LocalUser;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Desc: 购物车
 * Author: hp
 * Date: 2016/8/26
 */
@Service("sysCartService")
public class SysCartService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcOrderService orderService;

    public ShoppingCartInfo getShoppingCart(AddressDto address) {

        ShoppingCart shoppingCart = cartService.getShoppingCart(LocalUser.getUser().getUserId());
        List<CartInfo> cartInfos = shoppingCart.getCartInfos();

        ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
        // 配送地址
        if (address.getId() != null && !"".equals(address.getId())) {
            if (address.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(address.getId());
                Member member = userService.getMemberById(LocalUser.getUser().getUserId());
                shoppingCartInfo.setMobile(member.getMobile());
                shoppingCartInfo.setAddress(arayacakAddress.getAddress());
                shoppingCartInfo.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(address.getId(), LocalUser.getUser().getUserId());
                shoppingCartInfo.setConsignee(addr.getConsignee());
                shoppingCartInfo.setMobile(addr.getMobile());
                shoppingCartInfo.setAddress(addr.getAddress());
                shoppingCartInfo.setSince(false);
            }
            shoppingCartInfo.setAddrId(address.getId());
        }else {
            DeliveryAddress addr = userService.getDefaultAddress(LocalUser.getUser().getUserId());
            shoppingCartInfo.setConsignee(addr.getConsignee());
            shoppingCartInfo.setMobile(addr.getMobile());
            shoppingCartInfo.setAddress(addr.getAddress());
            shoppingCartInfo.setSince(false);
            shoppingCartInfo.setAddrId(addr.getId());
        }

        if (null != cartInfos && !cartInfos.isEmpty()) {
            List<ProductInfo> productInfos = new ArrayList<>();
            BigDecimal totalPrice = new BigDecimal(0);
            int hasNum = 0;
            for (CartInfo cartInfo : cartInfos) {
                ProductInfo productInfo = new ProductInfo();
                Product product = productService.getDefaultPictureById(cartInfo.getProductId());
                if (null != product) {
                    productInfo.setProductId(product.getId());
                    productInfo.setProductImg(product.getDefaultPicture().getPictureUrl());
                    BigDecimal salePrice = product.getSalePrice();
                    if (cartInfo.isChoose() && product.getUnitsInStock()>0) {
                        totalPrice = totalPrice.add(salePrice.multiply(new BigDecimal(cartInfo.getQuantity())));
                    }
                    if (product.getUnitsInStock()>0) {
                        hasNum++;
                    }else {
                        cartService.changeUnchooseStatus(LocalUser.getUser().getUserId(), product.getId());
                    }
                    productInfo.setSalePrice(StringFormat.format(salePrice));
                    productInfo.setMarketPrice(StringFormat.format(product.getMarketPrice()));
                    productInfo.setName(product.getName());
                    productInfo.setNums(cartInfo.getQuantity());
                    productInfo.setDesc(product.getUnitDesc());
                    productInfo.setChoose(cartInfo.isChoose());
                    productInfo.setStock(product.getUnitsInStock()>0);
                    productInfos.add(productInfo);
                }
            }
            Collections.sort(productInfos, new ProductInfoComparator());
            shoppingCartInfo.setProducts(productInfos);
            shoppingCartInfo.setDeliveryDate(new DateTime().plusDays(1).toString("MM月dd日"));
            shoppingCartInfo.setTotalPrice(StringFormat.format(totalPrice));
            shoppingCartInfo.setFreight("2");
            shoppingCartInfo.setHasNum(hasNum);
            if (totalPrice.compareTo(BigDecimal.valueOf(5.00)) == -1) { // TODO 后台定义
                shoppingCartInfo.setFreight("2");// TODO 后台定义
            }else {
                shoppingCartInfo.setFreight("0");
            }
            shoppingCartInfo.setFreeFreightAmount("5");// TODO 后台定义
        }
        return shoppingCartInfo;
    }

    public ProductCartInfo addProduct(String productId) {
        Product product = productService.getById(productId);
        // 获取该商品的数量
        Long count = cartService.addProductCount(LocalUser.getUser().getUserId(), productId);
        if (product.getUnitsInStock() < count) {
            cartService.subProductCount(LocalUser.getUser().getUserId(), productId);
            throw new ProductException(StatusCode.PRODUCT_STOCK_SHORTAGE);
        }
        return chooseShoppingCartPrice(LocalUser.getUser().getUserId(), count);
    }

    public ProductCartInfo subProduct(String id) {
        // 获取该商品的数量
        Long count = cartService.subProductCount(LocalUser.getUser().getUserId(), id);
        return chooseShoppingCartPrice(LocalUser.getUser().getUserId(), count);
    }

    public ProductCartInfo deleteProduct(String id) {
        cartService.deleteProduct(LocalUser.getUser().getUserId(), id);
        return chooseShoppingCartPrice(LocalUser.getUser().getUserId(), null);
    }

    public ProductCartInfo changeStatus(String productId) {
        boolean isChoose = cartService.changeStatus(LocalUser.getUser().getUserId(), productId);
        ProductCartInfo productCart = chooseShoppingCartPrice(LocalUser.getUser().getUserId(), null);
        productCart.setChoose(isChoose);
        return productCart;
    }

    public ProductCartInfo chooseAllProduct() {
        cartService.chooseAllProduct(LocalUser.getUser().getUserId());
        return chooseShoppingCartPrice(LocalUser.getUser().getUserId(), null);
    }

    public ProductCartInfo unChooseAllProduct() {
        cartService.unchooseAllProduct(LocalUser.getUser().getUserId());
        return chooseShoppingCartPrice(LocalUser.getUser().getUserId(), null);
    }


    /**
     * 购物车商品的总价格
     * @return
     */
    public String getTotalPrice() {
        Set<String> productIds =  cartService.getChooseProductIds(LocalUser.getUser().getUserId());
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (String productId : productIds) {
            Product product = productService.getById(productId);
            if (product.getUnitsInStock() > 0) {
                // 根据Feild获取values 在乘以 单价 = total
                Long counts = cartService.getCounts(LocalUser.getUser().getUserId(), productId);
                totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(counts)));
            }
        }
        return StringFormat.format(totalPrice);
    }

    /**
     * 购物车已选择的商品的总价格(不包含无货的)
     * @param userId
     * @param currentCount
     * @return
     */
    private ProductCartInfo chooseShoppingCartPrice(String userId, Long currentCount) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        Set<String> productIds = cartService.getChooseProductIds(userId);
        for (String productId : productIds) {
            Product product = productService.getById(productId);
            if (product.getUnitsInStock() > 0) {
                Long count = cartService.getCounts(userId, productId);
                totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
            }
        }
        ProductCartInfo productCart = new ProductCartInfo();
        if (currentCount != null) {
            productCart.setCount(Integer.parseInt(currentCount+""));
        }
        productCart.setTotalPrice(StringFormat.format(totalPrice));
        if (totalPrice.compareTo(BigDecimal.valueOf(5.00)) == -1) {
            productCart.setFreight("2");
        }else {
            productCart.setFreight("0");
        }
        productCart.setFreeFreightAmount("5");

        return productCart;
    }

}
