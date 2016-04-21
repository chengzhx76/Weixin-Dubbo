package com.cheng.weixin.service.timer.token;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.common.constant.WeixinFinalValue;
import com.cheng.weixin.common.constant.WeixinUrl;
import com.cheng.weixin.common.exception.ErrorEntity;
import com.cheng.weixin.rpc.httpclient.service.RpcHttpClientService;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 刷新access_token 定时任务
 * @author Cheng
 */
@Component
public class RefreshAccessTokenTask {
	
	private static final Logger log = LoggerFactory.getLogger(RefreshAccessTokenTask.class);

	@Autowired
	private WeixinUrl weixinUrl;
	@Autowired
	private WeixinFinalValue weixinFinalValue;
	@Autowired
	private RpcHttpClientService httpClient;
	@Autowired
	private RpcRedisService redisService;


	public void test() {
		System.out.println("=======test======");
	}


	public void refreshToken() {
		log.info("=============================");

		String url = weixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", weixinFinalValue.APPID).replace("APPSECRET", weixinFinalValue.APPSECRET);
		String content = httpClient.doGet(url);

        ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
        if(err.getErrcode()!=null && !err.getErrcode().equals("0") && err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//            throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
			log.error("发生错误，错误码：{}，错误消息：{}，正在重试！", err.getErrcode(), err.getErrmsg());
			refreshToken();
        }else {
			System.err.println("Success===>");
			redisService.set("WEIXIN_ACCESS_TOKEN", content);
		}


//		try {
//			AccessToken accessToken = JSON.parseObject(content, AccessToken.class);
//			WeixinContent.setAccessToken(accessToken.getAccess_token());
//		} catch (WeixinException err) {
////			err.printStackTrace();
//			log.error("发生错误，错误码：{}，错误消息：{}，正在重试！", err.getCode(), err.getErrorMsg());
//			refreshToken();
//		}
	}
	
}
