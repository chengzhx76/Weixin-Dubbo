package com.cheng.weixin.service.user.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.user.entity.Member;
import org.springframework.stereotype.Repository;

/**
 * Desc: 用户基础信息
 * Author: cheng
 * Date: 2016/7/7
 */
@Repository
public interface MemberDaoMapper extends BaseDaoMapper<Member> {
}
