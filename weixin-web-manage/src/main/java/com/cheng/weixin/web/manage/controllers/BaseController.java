package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/1/20 0020
 */
public abstract class BaseController {
    /** 统一的日志对象 **/
    final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected RpcAdminService adminService;

    /**
     * 添加Model消息
     * @param model
     * @param attribute
     * @param messages
     */
    protected void addMessage(Model model, String attribute, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        model.addAttribute(attribute, sb.toString());
    }
}
