package com.cheng.weixin.rpc.wxtools.enums;

public enum Status {
	/** 成功 **/
	SUCCESS("success"),
	/** 用户拒收 **/
	USER_BLOCK("failed:user block"),
	/** 系统错误 **/
	SYSTEM_FAILED("failed: system failed");
	
	private String name;
	
	private Status() {
	}
	private Status(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
