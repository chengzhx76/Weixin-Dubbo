package com.cheng.weixin.service.log.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.log.entity.Log;
import org.springframework.stereotype.Repository;

/**
 * Desc: 日志
 * Author: hp
 * Date: 2016/10/18
 */
@Repository
public interface LogDaoMapper  extends BaseDaoMapper<Log> {
}
