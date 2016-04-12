package com.cheng.weixin.rpc.wxtools.request.model;

import java.io.Serializable;

public class WxMusic implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MediaId;
	private String Title;// 非必须
	private String Description;// 非必须
	private String MusicUrl;// 非必须
	private String HQMusicUrl;// 非必须
	private String ThumbMediaId;// 非必须

	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
		
}
