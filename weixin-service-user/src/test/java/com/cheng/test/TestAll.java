package com.cheng.test;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/19
 */
public class TestAll {


    public static void main(String[] args) {
        DateTime now = new DateTime();

        now.dayOfMonth().withMaximumValue().toDate();
        //Date currentMonth = DateTime.now().minusMonths(1).dayOfMonth().withMaximumValue().hourOfDay().withMaximumValue()..toDate();
        Date currentMonth = DateTime.now().dayOfMonth().withMinimumValue().hourOfDay().withMinimumValue().millisOfDay().withMinimumValue().toDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(currentMonth));


        System.out.println(now.dayOfMonth().withMaximumValue().toString("yyyyMMddEE"));
    }
}
