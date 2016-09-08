package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.ProductDto;
import com.cheng.weixin.web.mobile.result.cart.ProductCartInfo;
import com.cheng.weixin.web.mobile.result.cart.ShoppingCartInfo;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/08/27
 */
@RestController
@RequestMapping(value = "cart")
public class CartController extends BaseController {
    @Autowired
    private SysCartService sysCartService;

    /** 购物车信息 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/info")
    public ResponseEntity<Response> login(HttpServletRequest request) {
        ShoppingCartInfo shoppingCartInfo = sysCartService.getShoppingCart("1");
        return success(shoppingCartInfo);
    }
    /** 增加购物车的商品 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/add")
    public ResponseEntity<Response> add(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        ProductCartInfo productCart = sysCartService.addProduct("1", product.getProductId());
        return success(productCart);
    }

    /** 减少购物车的商品 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/sub")
    public ResponseEntity<Response> sub(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        ProductCartInfo productCart = sysCartService.subProduct("1", product.getProductId());
        return success(productCart);
    }
    /** 删除购物车的商品 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/delete")
    public ResponseEntity<Response> delete(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        ProductCartInfo productCart = sysCartService.subProduct("1", product.getProductId());
        return success(productCart);
    }
}
