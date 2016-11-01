package com.cheng.weixin.service.log.service;

import com.cheng.weixin.common.utils.Exceptions;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.log.entity.Log;
import com.cheng.weixin.rpc.log.enums.LogType;
import com.cheng.weixin.rpc.log.service.RpcLogService;
import com.cheng.weixin.service.log.dao.LogDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/18
 */
@Service("logService")
public class LogService implements RpcLogService {

    @Autowired
    private LogDaoMapper logDao;

    @Override
    public void saveLog(String remoteAddr, String userAgent, String requestUri, Map<String, String[]> params,
        String method, /*Object handler,*/ Exception ex, String title, String username) {
            Log log = new Log();
            log.setTitle(title);
            log.setType(ex == null ? LogType.ACCESS : LogType.EXCEPTION);
            log.setRemoteAddr(remoteAddr);
            log.setUserAgent(userAgent);
            log.setRequestUri(requestUri);
            log.setParams(params);
            log.setMethod(method);
            log.setUsername(username);
            // 异步保存日志
            new Thread(new SaveLogThread(log, /*handler,*/ ex)).start();
        }

        public class SaveLogThread implements Runnable {
            private Log log;
            //        private Object handler;
            private Exception ex;
            public SaveLogThread(Log log, /*Object handler,*/ Exception ex) {
                this.log = log;
//            this.handler = handler;
                this.ex = ex;
            }
            @Override
            public void run() {
                // 如果有异常，则保存异常信息
                log.setException(Exceptions.getStackTraceToString(ex));
                // 如果无标的并无异常日志，则不保存信息
                if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())) {
                    return;
                }
                // 保存日志信息
                log.preInsert();
                logDao.save(log);
            }
    }



}
