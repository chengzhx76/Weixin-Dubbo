package com.cheng.weixin.web.mobile.model;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/22
 */
public class Book {
    private String name;
    private Integer pageNum;

    private int hasPage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public int getHasPage() {
        return hasPage;
    }

    public void setHasPage(int hasPage) {
        this.hasPage = hasPage;
    }
}
