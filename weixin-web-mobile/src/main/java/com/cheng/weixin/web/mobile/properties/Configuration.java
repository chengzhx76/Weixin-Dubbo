package com.cheng.weixin.web.mobile.properties;

import org.apache.log4j.Logger;

import javax.naming.ConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载，并对配置文件进行基本操作
 * @author liuxm
 */
public class Configuration {
	static Logger log = Logger.getLogger(Configuration.class);
	
	private Properties config = new Properties();//配置
	private String fn = "/globalconf.properties";//配置文件名,有默认值
	public Configuration() {}
	/**
	 * 根据指定的文件名构造一个配置
	 * @param fileName
	 * @throws ConfigurationException
	 */
	public Configuration(String fileName) throws ConfigurationException {
		try {
			InputStream in = getClass().getResourceAsStream(fileName);
			config.load(in); //载入文件
//			log.debug("file path=" + System.class.getResourceAsStream(fileName));
			in.close();
		} catch (IOException ex) {
			log.error("Can't read files:" + fileName);
			throw new ConfigurationException("Can't read files:" + fileName);
		}
		fn = fileName;
	}
	/**
	 * 指定配置项名称，返回配置值
	 * @param itemName String 配置项名称
	 * @return String 配置值
	 */
	public String getValue(String itemName) {
		return config.getProperty(itemName);
	}

	/**
	 * 指定配置项名称和默认值，返回配置值
	 * @param itemName String 配置项名称
	 * @param defaultValue String 默认配置值
	 * @return String 配置值
	 */
	public String getValue(String itemName, String defaultValue) {
		String result = config.getProperty(itemName, defaultValue);
		return result;
	}

	/**
	 * 设置配置项名称及其值
	 * @param itemName String,配置项名
	 * @param value String,配置值
	 */
	public void setValue(String itemName, String value) {
		config.setProperty(itemName, value);
		return;
	}

	/**
	 * 保存配置文件，指定文件名和抬头描述
	 * @param fileName String,保存配置的文件名
	 * @param description String,抬头描述
	 * @throws ConfigurationException 文件无法保存
	 */
	public void saveFile(String fileName, String description)
			throws ConfigurationException {
		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			config.store(fout, description);//保存文件
			fout.close();
		} catch (IOException ex) {
			log.error("Can't not save files:" + fileName);
			throw new ConfigurationException("Can't not save files:" + fileName);
		}
	}
	/**
	 * 保存配置文件，指定文件名
	 * @param fileName String,保存配置的文件名
	 * @throws ConfigurationException 文件无法保存
	 */
	public void saveFile(String fileName) throws ConfigurationException {
		saveFile(fileName, "");
	}
	/**
	 *保存配置文件，采用原文件名。当读取文件时，类会记录文件读取的来源。
	 * @throws ConfigurationException 必须指定一个文件保存
	 */
	public void saveFile() throws ConfigurationException {
		if (fn.length() == 0){
			log.error("Must spification a file to save");
			throw new ConfigurationException("Must spification a file to save");
		}
		saveFile(fn);
	}
}