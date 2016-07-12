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
    /**
     * 当天发送的短信个数
     * @param smsHistory
     * @return
     */
    int loadOneDayCount(SmsHistory smsHistory);
    /**
     * 当前IP发送的短信个数
     * @param smsHistory
     * @return
     */
    int loadCurrentIpCount(SmsHistory smsHistory);

    /**
     * 获取最近的一条记录
     * @param smsHistory
     * @return
     */
    SmsHistory loadNewByPhoneAndType(SmsHistory smsHistory);
}
