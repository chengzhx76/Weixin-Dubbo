package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.exception.ProductException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.ProductDto;
import com.cheng.weixin.web.mobile.result.index.Index;
import com.cheng.weixin.web.mobile.result.index.IndexBuy;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 首页
 * Author: cheng
 * Date: 2016/6/21
 */
@RestController
public class IndexController extends BaseController {
    @Autowired
    private SysIndexService sysIndexService;

    @RequestMapping(value = "v1/index1")
    public ResponseEntity<Response> index1() {

        throw new ProductException(StatusCode.COUPON_EXCEPTION);

        //return success();
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/index")
    public ResponseEntity<Response> index(HttpServletRequest request) {
        Index index = sysIndexService.getIndexInfo("1");
        return success(index);
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/add")
    public ResponseEntity<Response> add(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        IndexBuy indexBuy = sysIndexService.addProduct(productDto.getProductId());
        return success(indexBuy);
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/sub")
    public ResponseEntity<Response> sub(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        IndexBuy indexBuy = sysIndexService.subProduct(productDto.getProductId());
        return success(indexBuy);
    }

}
