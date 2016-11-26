package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.LoginDto;
import com.cheng.weixin.web.mobile.param.RegDto;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.security.LocalUser;
import com.cheng.weixin.web.mobile.security.TokenManager;
import com.cheng.weixin.web.mobile.security.User;
import com.cheng.weixin.web.mobile.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 登录
 * Author: cheng
 * Date: 2016/7/8
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private SysLoginService sysLoginService;
    @Autowired
    private TokenManager tokenManager;
    /** 发送验证码 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/sendMsgCode")
    public ResponseEntity<Response> sendMsgCode(HttpServletRequest request) {
        RegDto userDto = (RegDto) getDto(request, RegDto.class);
        sysLoginService.sendRegMsgCode(userDto.getPhone());
        return success();
    }

    /** 验证验证码 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/checkCode")
    public ResponseEntity<Response> checkCode(HttpServletRequest request) {
        RegDto reg = (RegDto) getDto(request, RegDto.class);
        return success(sysLoginService.checkCode(reg.getPhone(), reg.getValidate()));
    }

    /** 保存注册信息 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/register")
    public ResponseEntity<Response> register(HttpServletRequest request) {
        RegDto reg = (RegDto) getDto(request, RegDto.class);
        return success(sysLoginService.saveAccess(reg));
    }

    /** 登陆 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/login")
    public ResponseEntity<Response> login(HttpServletRequest request) {
        LoginDto loginDto = (LoginDto) getDto(request, LoginDto.class);
        String token = sysLoginService.login(loginDto);
        return success(token);
    }
    /** 检查Token是否超时 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/token")
    public ResponseEntity<Response> checkToken(HttpServletRequest request) {
        String token = request.getParameter("token");
        return success(tokenManager.checkToken(token));
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/setToken")
    public ResponseEntity<Response> setToken() {
        String token = tokenManager.createToken("18600536683");
        return success(token);
    }


    @RequestMapping(value = "v1/user")
    public ResponseEntity<Response> getUserInfoByToken() {
        User user = LocalUser.getUser();
        return success(user);
    }
}
