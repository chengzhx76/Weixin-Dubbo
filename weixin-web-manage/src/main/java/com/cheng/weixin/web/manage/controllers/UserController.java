package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.web.manage.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Desc: 用户
 * Author: Cheng
 * Date: 2016/3/28 0028
 */
@Controller
public class UserController extends BaseController  {
    /**
     * 获取当前登录者的信息
     * @param model
     * @return
     */
    @RequestMapping(value = "myinfo",method = RequestMethod.GET)
    public String selfInfo(Model model) {
        Admin admin = adminService.getAdminById(UserUtils.getPrincipal().getId());
        model.addAttribute("admin", admin);
        return "user/myInfo";
    }
}
