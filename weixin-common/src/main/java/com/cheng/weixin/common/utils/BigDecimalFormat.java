package com.cheng.weixin.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Desc: BigDecimal格式化
 * Author: 光灿
 * Date: 2016/6/28
 */
public class BigDecimalFormat {
    /**
     * 保留一位小数
     * @param value
     * @return
     */
    public static String format(BigDecimal value) {
        DecimalFormat format=new DecimalFormat("0.0");
        return format.format(value);
    }
}
