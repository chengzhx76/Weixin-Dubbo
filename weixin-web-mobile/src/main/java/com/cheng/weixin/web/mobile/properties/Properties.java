package com.cheng.weixin.web.mobile.properties;


import org.apache.log4j.Logger;

import javax.naming.ConfigurationException;

/**
 * 读取Properties配置文件
 * @author liuxm
 */
public class Properties {
	static Logger log = Logger.getLogger(Properties.class);
	
	public static String GLOBAL_CONF_FILE_NAME="/globalconf.properties";
	private static Properties properties = null;
	private Configuration config = null;
	private String classesPath=null;

	private Properties() {
	}
	/**
	 * Properties静态工厂
	 * @return GlobalConf
	 * @throws ConfigurationException 无法创建Properties
	 */
	public static Properties getInstance(){
		if (properties == null) {
			properties = new Properties();
			try {
				properties.config = new Configuration(GLOBAL_CONF_FILE_NAME);
			} catch (ConfigurationException e) {
				log.error("", e);
			}
		}
		return properties;
	}

	public String getValue(String key,String defalutValue) {
		return config.getValue(key,defalutValue);
	}
	
	public String getValue(String key) {
		return config.getValue(key);
	}
	
	public int getIntValue(String key,int defaultValue) {
		int value = 0;
		value = Integer.parseInt(getValue(key,""+defaultValue));
		return value;
	}

	public int getIntValue(String key) {
		int value = 0;
		value = Integer.parseInt(getValue(key));
		return value;
	}
	
	public long getLongValue(String key,long defaultValue) {
		long value = 0;
		value = Long.parseLong(getValue(key,""+defaultValue));
		return value;
	}
	
	public boolean getBooleanValue(String key,boolean defaultValue) {
		boolean value = true;
		value = Boolean.parseBoolean(getValue(key,"" + defaultValue));
		return value;
	}
	
	public boolean getBooleanValue(String key) {
		boolean value = true;
		value = Boolean.parseBoolean(getValue(key));
		return value;
	}
	
	public void setValue(String key, String value) throws ConfigurationException {
		config.setValue(key, value);
		config.saveFile();
	}
	
	/**
     * @return Returns the classesPath.
     */
    public String getClassesPath() {
        return classesPath;
    }
    /**
     * @param classesPath The classesPath to set.
     */
    public void setClassesPath(String classesPath) {
        this.classesPath = classesPath;
    }
}