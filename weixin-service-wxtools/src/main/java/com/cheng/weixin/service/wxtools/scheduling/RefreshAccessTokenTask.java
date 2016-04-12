package com.cheng.weixin.service.wxtools.scheduling;

import com.cheng.weixin.rpc.wxtools.content.WeixinContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 刷新access_token 定时任务
 * @author Cheng
 */
public class RefreshAccessTokenTask {
	
	private static final Logger log = LoggerFactory.getLogger(RefreshAccessTokenTask.class);
	private static String accessToken = "o12HLOcPn7UlUl9MwtpJZFzQhOAiTBbidZuZlyk8iUWcLUheuAm0_rHJNnndTsLkeRmkUSGhAFADBP";

	static {
		WeixinContent.getInstance().setAccessToken(accessToken);
		log.info("已把access_token放入");
	}
	
	public void refreshToken() {
		
		System.err.println("=============================");
		
		/*
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replace("APPSECRET", WeixinFinalValue.APPSECRET);
		try {
			String content = HttpUtils.httpGet(url);
			AccessToken accessToken = JSON.parseObject(content, AccessToken.class);
			WeixinContent.setAccessToken(accessToken.getAccess_token());
		} catch (WeixinException err) {
//			err.printStackTrace();
			log.error("发生错误，错误码：{}，错误消息：{}，正在重试！", err.getCode(), err.getErrorMsg());
			refreshToken();
		}
	 */
	}
	
}
