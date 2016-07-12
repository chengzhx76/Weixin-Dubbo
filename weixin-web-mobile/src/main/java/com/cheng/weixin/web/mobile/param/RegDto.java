package com.cheng.weixin.web.mobile.param;

/**
 * Desc: 用户
 * Author: cheng
 * Date: 2016/7/4
 */
public class RegDto {
    private String phone;
    private String validate;
    private String nickname;
    private String password;

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
