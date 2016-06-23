package com.cheng.weixin.web.mobile.security;

import java.lang.annotation.*;

/**
 * Desc: 忽略安全性检查
 * Author: cheng
 * Date: 2016/6/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
