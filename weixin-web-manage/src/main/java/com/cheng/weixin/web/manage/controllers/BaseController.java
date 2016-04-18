package com.cheng.weixin.web.manage.controllers;

import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/1/20 0020
 */
public abstract class BaseController {
    /** 统一的日志对象 **/
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected RpcAdminService adminService;
}
