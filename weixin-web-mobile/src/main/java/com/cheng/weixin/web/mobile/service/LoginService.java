package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.ServletUtils;
import com.cheng.weixin.common.utils.SystemUtils;
import com.cheng.weixin.rabbitmq.model.SmsModel;
import com.cheng.weixin.rpc.rabbitmq.service.RpcRabbitSmsService;
import com.cheng.weixin.web.mobile.json.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 登录
 * Author: cheng
 * Date: 2016/7/8
 */
@Service("loginService")
public class LoginService {

    @Autowired
    private RpcRabbitSmsService rabbitService;
    /**
     * 发送验证码
     * @param phone
     */
    public void sendRegMsgCode(String phone) {
        String userIp = SystemUtils.getRemoteAddr(ServletUtils.getRequest());
        SmsModel smsModel = new SmsModel();
        smsModel.setUserIp(userIp);
        smsModel.setPhone(phone);
        rabbitService.sendValidate(smsModel);
    }

}
