package com.cheng.weixin.web.mobile.model;

/**
 * Desc: 返回封装的实体
 * Author: cheng
 * Date: 2016/6/21
 */
public class Response {

    private Meta meta;
    private Object data;

    public Response() {}

    // 成功||失败-状态码-成|败-消息-数据
    public Response(int code, boolean success, String message, Object data) {
        this.meta = new Meta(code, success, message);
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
