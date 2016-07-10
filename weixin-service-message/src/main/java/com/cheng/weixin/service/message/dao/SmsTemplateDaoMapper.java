package com.cheng.weixin.service.message.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.message.entity.SmsTemplate;
import org.springframework.stereotype.Repository;

/**
 * Desc: 短信模板
 * Author: 光灿
 * Date: 2016/7/10
 */
@Repository
public interface SmsTemplateDaoMapper extends BaseDaoMapper<SmsTemplate> {
    /**
     * 获取正在使用的模板
     * @return
     */
    SmsTemplate loadEnable();

}
