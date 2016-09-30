package com.cheng.weixin.service.user.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.user.entity.CouponRecord;
import org.springframework.stereotype.Repository;

/**
 * Desc: 记录券的收支情况
 * Author: cheng
 * Date: 2016/7/7
 */
@Repository
public interface CouponRecordDaoMapper extends BaseDaoMapper<CouponRecord> {
    /**
     * 根据用户获取券记录
     * @param couponRecord
     * @return
     */
    CouponRecord loadByUser(CouponRecord couponRecord);

}
