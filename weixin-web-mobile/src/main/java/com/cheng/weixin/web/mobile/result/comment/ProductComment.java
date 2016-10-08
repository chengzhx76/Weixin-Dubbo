package com.cheng.weixin.web.mobile.result.comment;

/**
 * Desc: 评论
 * Author: hp
 * Date: 2016/10/8
 */
public class ProductComment {
    private String username;
    private String level;
    private String date;
    private String content;
    private String reply;

    public ProductComment() {
    }

    public ProductComment(String username, String level, String date, String content, String reply) {
        this.username = username;
        this.level = level;
        this.date = date;
        this.content = content;
        this.reply = reply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
