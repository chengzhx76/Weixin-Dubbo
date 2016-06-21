package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: 首页
 * Author: cheng
 * Date: 2016/6/21
 */
@RestController
//@Controller
public class IndexController extends BaseController {


    @RequestMapping(value = "v1/index")
    public ResponseEntity<Response> index() {

        return setSuccess();
    }

}
