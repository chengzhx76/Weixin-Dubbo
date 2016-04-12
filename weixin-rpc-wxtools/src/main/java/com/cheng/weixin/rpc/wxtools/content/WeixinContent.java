package com.cheng.weixin.rpc.wxtools.content;

public class WeixinContent {
	
	private WeixinContent(){}
	
	private static class SingletonHolder {
		public static final WeixinContent instance = new WeixinContent();
	}
	
	public static WeixinContent getInstance() {
		return SingletonHolder.instance;
	}
	
//	private String accessToken;
	private static String accessToken = "YwQ1YAO9kVLY-OM6A4Cn5IIt4QC25ixcNV00y_vYS4jFhtTUFMs1OK9HUdQKFsgTkjPPzjhIcClkoz2804GtkjJD-tXfF-x4aHcxdQO-yH4GRIgAEANYP";
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
