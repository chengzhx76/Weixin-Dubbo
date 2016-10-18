package com.cheng.weixin.service.log.service;

import com.cheng.weixin.service.log.dao.LogDaoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc: MQ实现保存日志
 * Author: Cheng
 * Date: 2016/4/25 0025
 */

public class LogMQService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogMQService.class);
    @Autowired
    private LogDaoMapper logDao;

    public void saveLogs() {

    }
}
