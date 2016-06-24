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

    // 失败-状态码-原因
    //public Response(int code, String message) {
    //    this.meta = new Meta(code, message);
    //}
    //// 成功
    //public Response(boolean success) {
    //    this.meta = new Meta(success);
    //}
    //// 成功-状态码
    //public Response(int code) {
    //    this.meta = new Meta(code, true);
    //}
    //// 成功-消息-数据
    //public Response(String message, Object data) {
    //    this.meta = new Meta(true, message);
    //    this.data = data;
    //}

    // 成功-状态码-消息-数据
    //public Response(int code, String message, Object data) {
    //    this.meta = new Meta(code, true, message);
    //    this.data = data;
    //}

    // 成功||失败-状态码-成|败-消息
    //public Response(int code, boolean success, String message) {
    //    this.meta = new Meta(code, success, message);
    //}

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
