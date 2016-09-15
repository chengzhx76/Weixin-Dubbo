package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.cart.model.ProductModel;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.order.entity.DeliveryTime;
import com.cheng.weixin.rpc.order.entity.Pay;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.entity.DeliveryAddress;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/14
 */
@Service("sysOrderService")
public class SysOrderService {
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcOrderService orderService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    public void buy() {
        // 配送地址
        DeliveryAddress address = userService.getDefaultAddress();

        // 配送时间
        List<DeliveryTime> time = orderService.getAllDeliveryTime();

        // 支付方式
        List<Pay> pays = orderService.getAllPay();

        // 优惠券

        // 余额
        Account account = userService.getAccount("1");

        // 商品详情
        int totalProductNums = 0;
        BigDecimal totalProductPrice = new BigDecimal(0);
        List<ProductModel> productModels = cartService.getChooseProductInfo("1");
        String[] productImgs = new String[productModels.size()];
        for (int i=0; i<productModels.size(); i++) {
            Product product = productService.getById(productModels.get(i).getId());
            productImgs[i] = product.getDefaultPicture().getPictureUrl();
            totalProductNums+=productModels.get(i).getCount();
            totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(new BigDecimal(productModels.get(i).getCount())));
        }
        // 运费
        BigDecimal freight = new BigDecimal(5.00);

        // 优惠券
        BigDecimal couponRecord = new BigDecimal(0.00);

    }

}
