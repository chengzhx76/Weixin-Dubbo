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
@RequestMapping("cart")
public class CartController extends BaseController {
    @Autowired
    private SysCartService sysCartService;

    /** 购物车信息 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/info")
    public ResponseEntity<Response> info(HttpServletRequest request) {
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
        ProductCartInfo productCart = sysCartService.deleteProduct("1", product.getProductId());
        return success(productCart);
    }

    /** 改变选择状态 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/change")
    public ResponseEntity<Response> changeStatus(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        ProductCartInfo productCart = sysCartService.changeStatus("1", product.getProductId());
        return success(productCart);
    }

    /** 购买 **/
/*    @RequestMapping(value = "v1/buy")
    public ResponseEntity<Response> buy(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        return success();
    }*/


    /** 批量添加商品到购物车 **/
/*    @IgnoreSecurity
    @RequestMapping(value = "v1/batchDelete")
    public ResponseEntity<Response> batchAdd(HttpServletRequest request) {
        List<ProductDto> products = (List<ProductDto>) getDto(request, ProductDto.class);
        ProductCartInfo productCart = sysCartService.batchAddProduct("1", products);
        return success(productCart);
    }*/
}
