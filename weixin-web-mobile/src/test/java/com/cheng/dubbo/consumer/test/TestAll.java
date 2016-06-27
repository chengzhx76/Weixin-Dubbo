package com.cheng.dubbo.consumer.test;

import com.cheng.weixin.common.security.Digests;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/24
 */
public class TestAll {

    @org.junit.Test
    public void test01() {
        int[] ids = {1,2,3};
        for (int i=0; i<ids.length;i++) {
            System.out.println(ids[i]);
        }
        for (int i=0; i<ids.length;i++) {
            System.out.println(ids[i]);
        }
    }

    @Test
    public void test02() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test03() throws UnsupportedEncodingException {
        long time = System.currentTimeMillis();
        System.out.println(time);
        String param = time+"weixin"+"122";

        System.out.println(Digests.md5(param));
    }
    @Test
    public void test04() throws UnsupportedEncodingException {
        String param = "1228358c427e15ec4244c86111dceee696a";
        System.out.println(Digests.md5(param));
    }
}
