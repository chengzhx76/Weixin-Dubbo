package com.cheng.weixin.rpc.wxtools.request.model;

import java.io.Serializable;

public class ModelMsgData implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String value;
	private String color;
	
	public ModelMsgData(String value, String color) {
		this.value = value;
		this.color = color;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
