package com.cheng.weixin.rpc.log.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.rpc.log.enums.LogType;

import java.util.Date;
import java.util.Map;

/**
 * Desc: 日志
 * Author: Cheng
 * Date: 2016/3/23 0023
 */
public class Log extends DataEntity<Log> {
    /** 类型 **/
    private LogType type;
    /** 标题 **/
    private String title;
    /** 操作用户的IP地址 **/
    private String remoteAddr;
    /** 操作的URI **/
    private String requestUri;
    /** 操作的方式 **/
    private String method;
    /** 操作提交的数据 **/
    private String params;
    /** 操作用户的代理信息 **/
    private String userAgent;
    /** 异常信息 **/
    private String exception;
    /** 操作人 **/
    private String username;
    /** 开始时间 **/
    private Date beginDate;
    /** 结束时间 **/
    private Date endDate;

    public LogType getType() {
        return type;
    }

    public void setType(LogType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 设置请求参数
     * @param paramMap
     */
    public void setParams(Map<String, String[]> paramMap) {
        if (paramMap == null) {
            return;
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "";
            params.append(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue);
        }
        this.params = params.toString();
    }
}
