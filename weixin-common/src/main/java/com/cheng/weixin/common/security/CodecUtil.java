package com.cheng.weixin.common.security;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Desc: 编码与解码操作工具类
 * Author: cheng
 * Date: 2016/6/22
 */
public class CodecUtil {

    private static Logger logger = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 创建随机数
     */
    public static String createRandomNum(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    /**
     * 获取 UUID（32位）
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
