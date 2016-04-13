package com.cheng.weixin.web.front.interceptor;

import com.cheng.weixin.commom.utils.DateUtils;
import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.rpc.log.service.RpcLogService;
import com.cheng.weixin.web.front.utils.UserUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc: 日志拦截器
 * Author: Cheng
 * Date: 2016/3/23 0023
 */
public class LogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    private RpcLogService logService;

    private ThreadLocal<Long> runTimeThreadLocal = new NamedThreadLocal<>("run time ThreadLocal");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (logger.isDebugEnabled()) {
            long beginTime = System.currentTimeMillis(); // 开始时间
            runTimeThreadLocal.set(beginTime);
            logger.debug("开始时间：{} URI：{}", new DateTime(beginTime).toString("hh:mm:ss.SSS"), request.getRequestURI());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null) {
            logger.info("ViewName：{}", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 保存日志
        logService.saveLog(StringUtils.getRemoteAddr(request),request.getHeader("user-agent"),request.getRequestURI(),
                request.getParameterMap(),request.getMethod(),/*handler,*/ ex, null, UserUtils.getPrincipal().getUsername());

        if (logger.isDebugEnabled()) {
            long beginTime = runTimeThreadLocal.get(); // 开始时间
            long endTime = System.currentTimeMillis(); // 结束时间
            logger.debug("计时结束：{} 耗时：{} URI：{} 最大内存：{}m 已分配内存：{}m 已分配内存中的剩余空间：{}m 最大可用内存：{}m",
                    new DateTime(endTime).toString("hh:mm:ss.SSS"), DateUtils.formatDateTime(endTime - beginTime),
                    request.getRequestURI(),
                    Runtime.getRuntime().maxMemory()/1024/1024,
                    Runtime.getRuntime().totalMemory()/1024/1024,
                    Runtime.getRuntime().freeMemory()/1024/1024,
                    (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
        }

    }
}
