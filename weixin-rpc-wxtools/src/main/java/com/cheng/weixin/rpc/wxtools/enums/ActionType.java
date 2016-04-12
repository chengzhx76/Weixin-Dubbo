package com.cheng.weixin.rpc.wxtools.enums;
/**
 * 自定义菜单接口多种活动类型按钮
 * @author Cheng
 */
public enum ActionType {
	click("点击推事件"),
	view("跳转URL"),
	scancode_push("扫码推事件"),
	scancode_waitmsg("扫码推事件且弹出“消息接收中”提示框"),
	pic_sysphoto("弹出系统拍照发图"),
	pic_photo_or_album("弹出拍照或者相册发图"),
	pic_weixin("弹出微信相册发图器"),
	location_select("弹出地理位置选择器"),
	media_id("下发消息（除文本消息）"),
	view_limited("跳转图文消息URL");
	
	private String name;

	private ActionType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
