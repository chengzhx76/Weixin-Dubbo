package com.cheng.weixin.service.message.service;

import com.cheng.weixin.common.security.CodecUtil;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import com.cheng.weixin.rpc.message.entity.SmsTemplate;
import com.cheng.weixin.rpc.message.enums.MsgType;
import com.cheng.weixin.rpc.message.service.RpcSmsService;
import com.cheng.weixin.service.message.dao.SmsHistoryDaoMapper;
import com.cheng.weixin.service.message.dao.SmsTemplateDaoMapper;
import com.cheng.weixin.service.message.model.SmsModel;
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
    public void sendRegMsgCode(Object msgData) throws Exception {

        SmsTemplate smsTemplate = smsTemplateDao.loadEnable();
        String code = CodecUtil.createRandomNum(4);
        //SmsModel smsModel = JSONUtils.json2pojo(data, SmsModel.class);
        SmsModel smsModel = (SmsModel) msgData;
        String content =  StringUtils.replace(smsTemplate.getContent(), "[MSGCODE]", code);

        // 发送短信 开始
        System.out.println("开始发送短信===> "+content);

        // 保存短息历史纪录
        SmsHistory history = new SmsHistory();
        history.setPhone(smsModel.getPhone());
        history.setUserIp(smsModel.getUserIp());
        history.setContent(content);
        history.setSender("system");
        history.setTimeout(10);
        history.setType(MsgType.REGISTER);
        history.setValidate(code);
        smsHistoryDao.save(history);
    }
}
