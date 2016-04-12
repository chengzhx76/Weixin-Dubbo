package com.cheng.weixin.rpc.wxtools.request.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 模版消息
 * @author Cheng
 *
 */
public class TemplateMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String touser;
	private String template_id;
	private String url;
	private Map<String,Serializable> data;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, Serializable> getData() {
		return data;
	}
	public void setData(Map<String, Serializable> data) {
		this.data = data;
	}
	
}
