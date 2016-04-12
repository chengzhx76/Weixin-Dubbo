package com.cheng.weixin.log.service;

import com.cheng.weixin.commom.utils.Exceptions;
import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.log.dao.LogDaoMapper;
import com.cheng.weixin.rpc.log.entity.Log;
import com.cheng.weixin.rpc.log.enums.LogType;
import com.cheng.weixin.rpc.log.service.RpcLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * Desc: 日志
 * Author: Cheng
 * Date: 2016/3/23 0023
 */
@Service("logService")
public class LogService implements RpcLogService {

//    private static LogDaoMapper logDao = SpringContextHolder.getBean(LogDaoMapper.class);
    @Autowired
    private LogDaoMapper logDao;
    /**
     * 保存日志
     * @param request
     * @param handler
     * @param ex
     * @param title
     * @param useranem
     */
    @Override
    public void saveLog(HttpServletRequest request, Object handler, Exception ex, String title, String useranem) {
        Log log = new Log();
        log.setTitle(title);
        log.setType(ex == null ? LogType.ACCESS : LogType.EXCEPTION);
        log.setRemoteAddr(StringUtils.getRemoteAddr(request));
        log.setUserAgent(request.getHeader("user-agent"));
        log.setRequestUri(request.getRequestURI());
        log.setParams(request.getParameterMap());
        log.setMethod(request.getMethod());
        log.setUsername(useranem);
        // 异步保存日志
        new Thread(new SaveLogThread(log, handler, ex)).start();
    }

    public class SaveLogThread implements Runnable {
        private Log log;
        private Object handler;
        private Exception ex;
        public SaveLogThread(Log log, Object handler, Exception ex) {
            this.log = log;
            this.handler = handler;
            this.ex = ex;
        }
        @Override
        public void run() {
            // 如果有异常，则保存异常信息
            log.setException(Exceptions.getStackTraceToString(ex));
            // 如果无标的并无异常日志，则不保存信息
            if (org.apache.commons.lang3.StringUtils.isBlank(log.getTitle()) && org.apache.commons.lang3.StringUtils.isBlank(log.getException())) {
                return;
            }
            // 保存日志信息
            log.preInsert();
            logDao.save(log);
        }
    }

}
