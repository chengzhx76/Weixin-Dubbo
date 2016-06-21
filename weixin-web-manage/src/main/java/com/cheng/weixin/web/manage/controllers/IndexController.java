package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.common.utils.CacheUtils;
import com.cheng.weixin.web.manage.security.SystemAuthorizingRealm.Principal;
import com.cheng.weixin.web.manage.utils.Captcha;
import com.cheng.weixin.web.manage.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 光灿
 * Date: 2016/1/24
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        Principal user = UserUtils.getPrincipal();
        // 登录成功后验证码记数清零
        Captcha.isValidateCodeLogin(user.getUsername(), false, true);
        return "index";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
//        List<User> users = userService.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        Map<String, Integer> testMap = (Map<String, Integer>) CacheUtils.getSysCache("loginFailMap");
        if (null == testMap) {
            testMap = new HashMap<>();
            CacheUtils.putSysCache("loginFailMap", testMap);
        }
        Integer testNum = testMap.get("test");
        if (null == testNum) {
            testNum = 0;
        }else {
            testNum++;
        }
        testMap.put("test", testNum);
        model.addAttribute("countNum", testNum);
        return "test";
    }

}
