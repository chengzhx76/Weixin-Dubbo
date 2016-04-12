package com.cheng.weixin.service.wxtools.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cheng.weixin.rpc.wxtools.response.model.WxGroup;
import com.cheng.weixin.rpc.wxtools.service.RpcWxGroupService;
import com.cheng.weixin.service.wxtools.httputils.HttpUtils;
import com.cheng.weixin.rpc.wxtools.constant.WeixinUrl;
import com.cheng.weixin.rpc.wxtools.content.WeixinContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxGroupService  implements RpcWxGroupService {

	@Autowired
	protected WeixinUrl weixinUrl;

	@Override
	public WxGroup addGroup(String name) {
		String url = weixinUrl.ADD_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());

		Map<String, Map<String, String>> parameter = new HashMap<>();
		Map<String, String> group = new HashMap<>();
		group.put("name", name);
		parameter.put("group", group);
		String data = JSON.toJSONString(parameter);
		String content = HttpUtils.httpPost(url, data);

		JSONObject repData = JSONObject.parseObject(content);
		WxGroup repGroup = repData.getObject("group", WxGroup.class);
		return repGroup;
	}

	@Override
	public List<WxGroup> getAllGroup() {
		String url = weixinUrl.QUERY_ALL_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		String content = HttpUtils.httpGet(url);
		Map<String, List<WxGroup>> repData = JSONObject.parseObject(content, new TypeReference<Map<String, List<WxGroup>>>(){});
		return repData.get("groups");
	}

	@Override
	public Integer getUserGroup(String openid) {
		String url = weixinUrl.QUERY_USER_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		Map<String, String> parameter = new HashMap<>();
		parameter.put("openid", openid);
		String data = JSON.toJSONString(parameter);
		String content = HttpUtils.httpPost(url, data);

		JSONObject repData = JSONObject.parseObject(content);
		return repData.getInteger("groupid");
	}

	@Override
	public void updateGroupName(int id, String name) {
		String url = weixinUrl.MODIFY_GROUP_NAME.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		Map<String, WxGroup> parameter = new HashMap<>();
		parameter.put("group", new WxGroup(id, name));
		String data = JSON.toJSONString(parameter);
		HttpUtils.httpPost(url, data);
	}

	@Override
	public void updateUserGroup(String openid, int groupid) {
		String url = weixinUrl.MOVE_USER_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("openid", openid);
		parameter.put("to_groupid", groupid);
		String data = JSON.toJSONString(parameter);
		HttpUtils.httpPost(url, data);
	}

	@Override
	public void updateBatchMoveUserGroup(List<String> openids, int groupid) {
		String url = weixinUrl.BATCH_MOVE_USER_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("openid_list", openids);
		parameter.put("to_groupid", groupid);
		String data = JSON.toJSONString(parameter);

		HttpUtils.httpPost(url, data);
	}

	@Override
	public void deleteGroup(int id) {
		String url = weixinUrl.DELETE_GROUP.replace("ACCESS_TOKEN", WeixinContent.getInstance().getAccessToken());
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("group", new WxGroup(id));
		String data = JSON.toJSONString(parameter);

		HttpUtils.httpPost(url, data);
	}

	//@Override
	//public BaseDaoMapper getBaseDao() {
	//	return groupDao;
	//}

}