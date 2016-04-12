package com.cheng.weixin.rpc.wxtools.request.model;

import java.util.List;

/**
 * 图文消息
 * @author Cheng
 */
public class NewsMessage extends BaseMessage {
	
	private static final long serialVersionUID = 1L;
	private List<WxNews> Articles;
	
	public List<WxNews> getArticles() {
		return Articles;
	}
	public void setArticles(List<WxNews> articles) {
		this.Articles = articles;
	}
}
