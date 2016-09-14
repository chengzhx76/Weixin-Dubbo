package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: 订单
 * Author: hp
 * Date: 2016/9/9
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    /** 购买 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/buy")
    public ResponseEntity<Response> buy(String[] ids) {

        return success();
    }
}
