package com.cheng.weixin.web.mobile.param;

/**
 * Desc: 分页
 * Author: cheng
 * Date: 2016/7/4
 */
public class PageDto {
    private String id;
    private int pageNum;
    private int pageSize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
