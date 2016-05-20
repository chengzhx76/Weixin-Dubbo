package com.cheng.weixin.service.admin.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.admin.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc: 角色mapper
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
@Repository
public interface RoleDaoMapper extends BaseDaoMapper<Role> {
    /**
     * 根据管理员ID获取角色
     * @param adminId
     * @return
     */
    List<Role> loadByAdminId(String adminId);
}
