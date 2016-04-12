package com.cheng.weixin.rpc.wxtools.service;


import com.cheng.weixin.rpc.wxtools.response.model.WxGroup;

import java.util.List;


/**
 * 微信分组管理
 * @author Cheng
 */
public interface RpcWxGroupService {
	/**
	 * 增加分组
	 * @param name
	 */
	WxGroup addGroup(String name);
	/**
	 * 查询所有分组
	 * @return
	 */
	List<WxGroup> getAllGroup();
	/**
	 * 查询用户所在分组
	 * @param openid
	 * @return
	 */
	Integer getUserGroup(String openid);
	/**
	 * 修改分组名
	 * @param id
	 * @param name
	 */
	void updateGroupName(int id, String name);
	/**
	 * 移动用户分组
	 * @param openid
	 * @param groupid
	 */
	void updateUserGroup(String openid, int groupid);
	/**
	 * 批量移动用户分组
	 * @param openids
	 * @param groupid
	 */
	void updateBatchMoveUserGroup(List<String> openids, int groupid);
	/**
	 * 删除分组
	 * @return 
	 */
	void deleteGroup(int id);
	
}
