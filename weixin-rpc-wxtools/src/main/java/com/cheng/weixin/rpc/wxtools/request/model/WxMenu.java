package com.cheng.weixin.rpc.wxtools.request.model;

import com.cheng.weixin.rpc.wxtools.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义菜单
 * @author Cheng
 *
 */
@JsonInclude(Include.NON_NULL)
public class WxMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ActionType type;
	private String key;
	private String url;
	/** 子菜单 **/
	private List<WxMenu> sub_button;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<WxMenu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WxMenu> sub_button) {
		this.sub_button = sub_button;
	}
	
}
