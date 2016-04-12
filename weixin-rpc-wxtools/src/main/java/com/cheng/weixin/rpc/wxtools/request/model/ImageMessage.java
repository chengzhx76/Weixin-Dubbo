package com.cheng.weixin.rpc.wxtools.request.model;

/**
 * 图片消息
 * @author Cheng
 */
public class ImageMessage extends BaseMessage {
	
	private static final long serialVersionUID = 1L;
	private WxImage Image;
	
	public WxImage getImage() {
		return Image;
	}
	public void setImage(WxImage image) {
		this.Image = image;
	}
	
}
