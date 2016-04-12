package com.cheng.weixin.rpc.wxtools.request.model;

import java.io.Serializable;

public class WxImage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}