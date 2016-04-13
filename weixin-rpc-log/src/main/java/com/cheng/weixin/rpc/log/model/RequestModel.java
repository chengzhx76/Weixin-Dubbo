package com.cheng.weixin.rpc.log.model;

import java.io.Serializable;

/**
 * Desc: 由于Dubbo不能传request，这里主要封装request里的参数 ！暂时没用到
 * Author: Cheng
 * Date: 2016/4/13 0013
 */
public class RequestModel implements Serializable {

    private static final long serialVersionUID = 28202096490589558L;
    private String remoteAddr; // 操作用户的IP地址
    private String userAgent;  // 操作用户的代理信息
    private String requestUri; // 操作的URI
    private String params;     // 操作提交的数据
    private String method;     // 操作的方式

    public RequestModel() {}

    public RequestModel(String remoteAddr, String userAgent, String requestUri, String params, String method) {
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
        this.requestUri = requestUri;
        this.params = params;
        this.method = method;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
