package com.cheng.weixin.service.message.service;

import com.cheng.weixin.common.security.CodecUtil;
import com.cheng.weixin.common.utils.JSONUtils;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import com.cheng.weixin.rpc.message.entity.SmsTemplate;
import com.cheng.weixin.rpc.message.enums.MsgType;
import com.cheng.weixin.rpc.message.service.RpcSmsService;
import com.cheng.weixin.service.message.dao.SmsHistoryDaoMapper;
import com.cheng.weixin.service.message.dao.SmsTemplateDaoMapper;
import com.cheng.weixin.service.message.model.SmsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 短信服务
 * Author: 光灿
 * Date: 2016/7/10
 */
@Service("smsService")
public class SmsService implements RpcSmsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SmsTemplateDaoMapper smsTemplateDao;
    @Autowired
    private SmsHistoryDaoMapper smsHistoryDao;

    @Override
    public void sendRegMsg(String msgData) {

        logger.info("==================> "+msgData);
        SmsTemplate smsTemplate = smsTemplateDao.loadRegTemp();
        String code = CodecUtil.createRandomNum(4);


        SmsModel smsModel = null;
        try {
            smsModel = JSONUtils.json2pojo(msgData, SmsModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //SmsModel smsModel = (SmsModel) msgData;

        String content = StringUtils.replace(StringUtils.replace(smsTemplate.getContent(), "@MSGCODE@", code), "@TIMEOUT@", smsTemplate.getTimeout()+"");

        // 发送短信 开始
        logger.info("开始发送短信===> "+content);

        // 保存短息历史纪录
        SmsHistory history = new SmsHistory();
        history.setPhone(smsModel.getPhone());
        history.setUserIp(smsModel.getUserIp());
        history.setContent(content);
        history.setSender("system");
        history.setTimeout(smsTemplate.getTimeout());
        history.setType(MsgType.REGISTER);
        history.setValidate(code);
        history.preInsert();
        smsHistoryDao.save(history);
    }
    @Override
    public void sendNotice(String msgData) {
        logger.info("==================> "+msgData);
    }

    @Override
    public void sendActivity(String msgData) {
        logger.info("==================> "+msgData);
    }
}
