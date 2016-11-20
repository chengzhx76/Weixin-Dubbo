package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.ProductDto;
import com.cheng.weixin.web.mobile.result.mall.ProductCategory;
import com.cheng.weixin.web.mobile.result.mall.Products;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Desc: 商城
 * Author: hp
 * Date: 2016/9/9
 */
@RestController
@RequestMapping("mall")
public class MallController extends BaseController {
    @Autowired
    private SysMallService mallService;

    /** 商品类型 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/category")
    public ResponseEntity<Response> productCategory() {
        List<ProductCategory> categories = mallService.getProductCategory();
        return success(categories);
    }
    /** 商品 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/products")
    public ResponseEntity<Response> product(HttpServletRequest request) {
        ProductCategory category = (ProductCategory) getDto(request, ProductCategory.class);
        List<Products> products = mallService.getMallProduct(category.getId());
        return success(products);
    }

    //@IgnoreSecurity
    @RequestMapping(value = "v1/add")
    public ResponseEntity<Response> add(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        long counts = mallService.addProduct(productDto.getProductId());
        return success(counts);
    }

    //@IgnoreSecurity
    @RequestMapping(value = "v1/sub")
    public ResponseEntity<Response> sub(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        long counts = mallService.subProduct(productDto.getProductId());
        return success(counts);
    }
}
