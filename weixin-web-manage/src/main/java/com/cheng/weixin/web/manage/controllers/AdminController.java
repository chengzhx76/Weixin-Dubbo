package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.web.manage.utils.SystemUtils;
import com.cheng.weixin.web.manage.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc: 用户
 * Author: Cheng
 * Date: 2016/3/28 0028
 */
@Controller
public class AdminController extends BaseController  {
    /**
     * 获取当前登录者的信息&更新用户信息
     * @param model
     * @return
     */
    @RequestMapping(value = "info")
    public String info(Admin admin, Model model) {
        Admin currentAdmin = UserUtils.getUser();
        if (StringUtils.isNotBlank(admin.getUsername())) {
            currentAdmin.setUsername(null);
            currentAdmin.setMobile(admin.getMobile());
            currentAdmin.setRemarks(admin.getRemarks());
            adminService.updateAdminInfo(currentAdmin);
            addMessage(model, "msg", "更新成功！");
            // 清除缓存
            UserUtils.clearCache(currentAdmin);
        }
        model.addAttribute("admin", currentAdmin);
        return "admin/info";
    }

    /**
     * 修改密码
     * @param oldPasswd
     * @param newPasswd
     * @param model
     * @return
     */
    @RequestMapping(value = "modifyPwd", method = RequestMethod.POST)
    public String modifyPwd(String oldPasswd, String newPasswd, Model model) {
        Admin currentAdmin = UserUtils.getUser();
        if (StringUtils.isNoneBlank(oldPasswd, newPasswd)) {
            if (SystemUtils.validatePassword(oldPasswd, currentAdmin.getPassword())) {
                adminService.updatePasswdById(currentAdmin.getId(), newPasswd);
                addMessage(model, "msg", "修改密码成功！");
                // 清除缓存
                UserUtils.clearCache(currentAdmin);
            }else {
                addMessage(model, "msg", "修改密码失败，旧密码错误！");
            }
        }
        model.addAttribute("admin", currentAdmin);
        return "admin/info";
    }

    /**
     * 保存用户
     * @param model
     * @param admin
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Model model, Admin admin) {
        if(checkUserName(admin.getUsername())) {
            addMessage(model, "msg", "添加用户" + admin.getUsername() + "失败，用户名已存在！");
        }
        admin.setPassword(SystemUtils.entryptPassword("abc1234"));
        adminService.add(admin);
        addMessage(model, "msg", "添加用户" + admin.getUsername() + "成功！");
        return "redirect:admin/list";
    }

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkName")
    public boolean checkUserName(String userName) {
        Admin admin = adminService.getAdminByUsername(userName);
        if (admin == null) {
            return true;
        }
        return false;
    }
}
