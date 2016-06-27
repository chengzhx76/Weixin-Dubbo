package com.cheng.weixin.web.mobile.properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 存放文件配置信息或者全局变量配置信息
 */
public class Global {
	private static final Logger logger = LoggerFactory.getLogger(Global.class);
	//版本号  Versions
	public static String APPSECRET;

	static{
		Properties properties = Properties.getInstance();
		APPSECRET = properties.getValue("wxclient");

	}
	
	public static void main(String[] args) {
		logger.info("sadsadaaaaaaaaaa");
    	System.out.println(Global.APPSECRET);
    }
}
