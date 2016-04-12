package com.cheng.weixin.rpc.wxtools.request.model;

/**
 * 语音消息
 * @author Cheng
 */
public class VoiceMessage extends BaseMessage {
	
	private static final long serialVersionUID = 1L;
	private WxVoice Voice;
	
	public WxVoice getVoice() {
		return Voice;
	}
	public void setVoice(WxVoice voice) {
		this.Voice = voice;
	}
}
