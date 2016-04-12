package com.cheng.weixin.rpc.wxtools.request.model;

import com.cheng.weixin.rpc.wxtools.enums.MsgType;

import java.io.Serializable;

/**
 * 被动回复基类消息
 * @author Cheng
 *
 */
public abstract class BaseMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private com.cheng.weixin.rpc.wxtools.enums.MsgType MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public MsgType getMsgType() {
		return MsgType;
	}
	public void setMsgType(MsgType msgType) {
		MsgType = msgType;
	}
}
