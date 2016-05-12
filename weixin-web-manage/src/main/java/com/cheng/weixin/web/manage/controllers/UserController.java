package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.web.manage.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping(value = "info"/*,method = RequestMethod.GET*/)
    public String info(Admin admin, Model model) {
        Admin currentAdmin = UserUtils.getUser();
        if (StringUtils.isNotBlank(admin.getUsername())) {
            currentAdmin.setUsername(null);
            currentAdmin.setMobile(admin.getMobile());
            currentAdmin.setRemarks(admin.getRemarks());
            adminService.updateAdminInfo(currentAdmin);
            model.addAttribute("msg", "更新成功");
            // 清除缓存
            UserUtils.clearCache(currentAdmin);
        }
        model.addAttribute("admin", currentAdmin);
        return "user/info";
    }
}
