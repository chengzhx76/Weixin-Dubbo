package com.cheng.weixin.web.mobile.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/22
 */
public class User {
    private int age;
    private String name;
    private String nickName;
    private BigDecimal haveAmount;
    private boolean sex;
    private Date birthday;


    private List<Book> books;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getHaveAmount() {
        return haveAmount;
    }

    public void setHaveAmount(BigDecimal haveAmount) {
        this.haveAmount = haveAmount;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
