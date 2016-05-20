package com.cheng.weixin.service.admin.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.admin.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc: 资源权限mapper
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
@Repository
public interface PermissionDaoMapper extends BaseDaoMapper<Permission> {
    /**
     * 根据管理员ID获取所属权限
     * @param adminId
     * @return
     */
    List<Permission> loadByAdminId(String adminId);
}
