package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:
 * Author: hp
 * Date: 2016/9/30
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    /** 购买 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/detail")
    public ResponseEntity<Response> detail() {
        return success();
    }
}
