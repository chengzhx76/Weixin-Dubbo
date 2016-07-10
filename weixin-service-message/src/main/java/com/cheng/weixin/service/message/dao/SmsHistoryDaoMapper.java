package com.cheng.weixin.service.message.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import org.springframework.stereotype.Repository;

/**
 * Desc: 短信
 * Author: 光灿
 * Date: 2016/7/10
 */
@Repository
public interface SmsHistoryDaoMapper extends BaseDaoMapper<SmsHistory> {
}
