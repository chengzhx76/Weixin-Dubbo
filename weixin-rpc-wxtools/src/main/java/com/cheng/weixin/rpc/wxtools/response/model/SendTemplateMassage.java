package com.cheng.weixin.rpc.wxtools.response.model;

import java.io.Serializable;

/**
 * 发送模版消息的回复
 * @author Cheng
 *
 */
public class SendTemplateMassage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String errcode;
	private String errmsg;
	private long msgid;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public long getMsgid() {
		return msgid;
	}
	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}
	
}
