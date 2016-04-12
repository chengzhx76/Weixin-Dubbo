package com.cheng.weixin.web.front.controllers;

import com.cheng.weixin.web.front.security.SystemAuthorizingRealm;
import com.cheng.weixin.web.front.security.WxFormAuthenticationFilter;
import com.cheng.weixin.web.front.utils.Captcha;
import com.cheng.weixin.web.front.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Author: 光灿
 * Date: 2016/1/24
 */
@Controller
public class LoginController extends BaseController {
    /** 登录页 **/
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        SystemAuthorizingRealm.Principal principal = UserUtils.getPrincipal();
        // 如果已经登录则跳转到管理首页
        if(principal != null) {
            return "redirect:index";
        }
        return "login";
    }
    /** 登录失败，登录验证有Shiro来完成 **/
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginFail(HttpServletRequest request, Model model) {
        String username = WebUtils.getCleanParam(request, WxFormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        String exception = (String) request.getAttribute(WxFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String message = (String) request.getAttribute(WxFormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
        if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")) {
            message = "用户名或密码错误.";
        }
        model.addAttribute(WxFormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        model.addAttribute(WxFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, exception);
        model.addAttribute(WxFormAuthenticationFilter.DEFAULT_MESSAGE_PARAM, message);

        // 非授权异常，登录失败，验证码加1。
        if (!UnauthorizedException.class.getName().equals(exception)){
            model.addAttribute("isValidateCodeLogin", Captcha.isValidateCodeLogin(username, true, false));
        }
        return "login";
    }

    @RequestMapping(value = "unauth",method = RequestMethod.GET)
    public String unauth() {

        log.info("没有权限访问!");

        return "unauth";
    }

    @RequestMapping(value = "drawCheckCode",method = RequestMethod.GET)
    public void drawCheckCode(HttpServletResponse resp, HttpSession session) throws IOException {
        resp.setContentType("image/jpg");
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        int width = 80;//设置验证码的宽度
        int height = 30;//验证码的高度
        Captcha c = Captcha.getInstance();
        c.set(width, height);
        String checkcode = c.generateCheckcode();
        session.setAttribute(Captcha.CAPTCHA,checkcode);
        OutputStream os = resp.getOutputStream();
        ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
    }
}
