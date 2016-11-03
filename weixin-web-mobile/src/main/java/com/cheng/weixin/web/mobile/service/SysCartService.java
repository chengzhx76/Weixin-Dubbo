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
import com.cheng.weixin.web.mobile.param.AddressDto;
import com.cheng.weixin.web.mobile.result.cart.ProductCartInfo;
import com.cheng.weixin.web.mobile.result.cart.ProductInfo;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        ShoppingCart shoppingCart = cartService.getShoppingCart("1");
        List<CartInfo> cartInfos = shoppingCart.getCartInfos();

        ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
        // 配送地址
        if (address.getId() != null && !"".equals(address.getId())) {
            if (address.getSince()) {
                ArayacakAddress arayacakAddress = orderService.getArayacakAddressById(address.getId());
                Member member = userService.getMemberById("1");
                shoppingCartInfo.setMobile(member.getMobile());
                shoppingCartInfo.setAddress(arayacakAddress.getAddress());
                shoppingCartInfo.setSince(true);
            }else {
                DeliveryAddress addr = userService.getDeliveryAddress(address.getId(), "1");
                shoppingCartInfo.setConsignee(addr.getConsignee());
                shoppingCartInfo.setMobile(addr.getMobile());
                shoppingCartInfo.setAddress(addr.getAddress());
                shoppingCartInfo.setSince(false);
            }
            shoppingCartInfo.setAddrId(address.getId());
        }else {
            DeliveryAddress addr = userService.getDefaultAddress("1");
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

    public ProductCartInfo addProduct(String id) {
        // 获取该商品的数量
        Long currentCount = cartService.addProductCount("1", id);
        return chooseShoppingCartPrice("1", currentCount);
    }

    public ProductCartInfo subProduct(String id) {
        // 获取该商品的数量
        Long currentCount = cartService.subProductCount("1", id);
        return chooseShoppingCartPrice("1", currentCount);
    }

    public ProductCartInfo deleteProduct(String id) {
        cartService.deleteProduct("1", id);
        return chooseShoppingCartPrice("1", null);
    }

    public ProductCartInfo changeStatus(String productId) {
        boolean isChoose = cartService.changeStatus("1", productId);
        ProductCartInfo productCart = chooseShoppingCartPrice("1", null);
        productCart.setChoose(isChoose);
        return productCart;
    }

    public ProductCartInfo chooseAllProduct() {
        cartService.chooseAllProduct("1");
        return chooseShoppingCartPrice("1", null);
    }

    public ProductCartInfo unChooseAllProduct() {
        cartService.unchooseAllProduct("1");
        return chooseShoppingCartPrice("1", null);
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
     * 购物车已选择的商品的总价格(不包含无货的)
     * @param userId
     * @param currentCount
     * @return
     */
    private ProductCartInfo chooseShoppingCartPrice(String userId, Long currentCount) {
        BigDecimal totalPrice = new BigDecimal(0);
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
