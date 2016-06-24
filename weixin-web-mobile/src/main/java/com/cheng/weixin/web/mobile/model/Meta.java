package com.cheng.weixin.web.mobile.model;

/**
 * Desc: 消息头
 * Author: cheng
 * Date: 2016/6/24
 */
public class Meta {
    // 状态码
    private int code;
    // 成功 || 失败
    private boolean success;
    // 消息
    private String msg;

    public Meta() {}

    public Meta(boolean success) {
        this.success = success;
    }
    public Meta(Integer code, boolean success) {
        this.code = code;
        this.success = success;
    }
    public Meta(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    public Meta(int code, boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }
    public Meta(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
