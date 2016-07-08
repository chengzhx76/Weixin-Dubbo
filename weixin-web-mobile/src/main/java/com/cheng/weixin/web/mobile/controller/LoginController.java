package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc: 登录
 * Author: cheng
 * Date: 2016/7/8
 */
public class LoginController extends BaseController {
    @RequestMapping(value = "v1/sendMsgCode")
    public ResponseEntity<Response> sendMsgCode() {





        return failure();
    }
}
