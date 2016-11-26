package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.ProductDto;
import com.cheng.weixin.web.mobile.result.product.ProductDetail;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/10/8
 */
@RestController
@RequestMapping("product")
public class ProductController extends BaseController {
    @Autowired
    private SysProductService productService;

    /** 获取商品详情 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/detail")
    public ResponseEntity<Response> sendMsgCode(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        ProductDetail detail = productService.getDetail(product.getProductId());
        return success(detail);
    }

    /** 购买商品 **/
    @RequestMapping(value = "v1/buy")
    public ResponseEntity<Response> buyProduct(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        productService.buyProduct(product.getProductId(), product.getCount());
        return success();
    }

    /** 收藏/取消收藏 商品 **/
    @RequestMapping(value = "v1/focus")
    public ResponseEntity<Response> addProductFocus(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        return success(productService.focus(product.getProductId()));
    }

    /** 检查库存 **/
    @Deprecated
    @IgnoreSecurity
    @RequestMapping(value = "v1/stock")
    public ResponseEntity<Response> checkStock(HttpServletRequest request) {
        ProductDto product = (ProductDto) getDto(request, ProductDto.class);
        productService.chackStock(product.getProductId());
        return success();
    }

    /** 批量购买商品 **/
    @Deprecated
    @RequestMapping(value = "v1/batch/add")
    public ResponseEntity<Response> batchAdd(HttpServletRequest request) throws UnsupportedEncodingException {
        List<ProductDto> products = (List<ProductDto>) getDto(request, ProductDto.class);
        productService.batchAdd(products);
        return success();
    }
}
