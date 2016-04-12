package com.cheng.weixin.rpc.wxtools.request.model;

/**
 * 语音消息
 * @author Cheng
 */
public class MediaMessage extends BaseMessage {
	
	private static final long serialVersionUID = 1L;
	private com.cheng.weixin.rpc.wxtools.response.model.WxMedia Media;
	
	public com.cheng.weixin.rpc.wxtools.response.model.WxMedia getMedia() {
		return Media;
	}
	public void setMedia(com.cheng.weixin.rpc.wxtools.response.model.WxMedia media) {
		this.Media = media;
	}
	
}
