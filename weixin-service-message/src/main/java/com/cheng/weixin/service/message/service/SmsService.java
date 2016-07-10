package com.cheng.weixin.service.message.service;

import com.cheng.weixin.common.security.CodecUtil;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import com.cheng.weixin.rpc.message.entity.SmsTemplate;
import com.cheng.weixin.rpc.message.enums.MsgType;
import com.cheng.weixin.rpc.message.service.RpcSmsService;
import com.cheng.weixin.service.message.dao.SmsHistoryDaoMapper;
import com.cheng.weixin.service.message.dao.SmsTemplateDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 短信服务
 * Author: 光灿
 * Date: 2016/7/10
 */
@Service("smsService")
public class SmsService implements RpcSmsService {
    @Autowired
    private SmsTemplateDaoMapper smsTemplateDao;
    @Autowired
    private SmsHistoryDaoMapper smsHistoryDao;

    @Override
    public void sendRegMsgCode(String data) {
        String code = CodecUtil.createRandomNum(4);
        SmsHistory history = new SmsHistory();
        history.setPhone();
        history.setUserIp();
        history.setContent();
        history.setSender("system");
        history.setTimeout();
        history.setType(MsgType.REGISTER);
        history.setValidate(code);
    }
}
