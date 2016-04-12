package com.cheng.shrio.passwd;


import com.cheng.weixin.admin.utils.SystemUtils;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/1/29 0029
 */
public class TestPssWd {

    //public static void main(String[] args) {
    //    System.out.println(new Md5Hash("cheng123","123").toHex());
    //}

    public static void main(String[] args) {
//		entryptPassword("cheng123");
        System.out.println(SystemUtils.validatePassword("cheng123", "5cdefe986d7fa0d363930c4062b776bd30a33a3cec47a34291a8bd27"));
    }
}
