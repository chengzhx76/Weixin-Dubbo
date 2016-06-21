package com.cheng.weixin.web.mobile.model;

/**
 * Desc: 返回封装的实体
 * Author: cheng
 * Date: 2016/6/21
 */
public class Response {
    public static final String OK = "ok";
    public static final String ERROR = "error";

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

    /**
     * 消息头
     */
    private class Meta {
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

    public static String getOK() {
        return OK;
    }

    public static String getERROR() {
        return ERROR;
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
