package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.result.user.UserDetail;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SysUserService userService;

    /** 个人详细信息 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/detail")
    public ResponseEntity<Response> detail() {
        UserDetail detail = userService.getUserDetail();
        return success(detail);
    }
}
