package com.cheng.weixin.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc: 时间工具
 * Author: Cheng
 * Date: 2016/3/23 0023
 */
public class DateUtils {
    public static final String YYYY_YEAR_MM_MONTH_DD_DATE = "yyyy年MM月dd日";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_BIAS_MM_BIAS_DD = "yyyy/MM/dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";
    public static final String HH = "HH";
    public static final String MI = "mm";
    public static final String SS = "ss";
    public static final String SIMPLE_YYYY_MM_DD = "yyyyMMdd";
    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis){
        long day = timeMillis/(24*60*60*1000);
        long hour = (timeMillis/(60*60*1000)-day*24);
        long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
        long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
        long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
        return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }

    public static Date toDate(String date, String format) throws ParseException {
        if(date == null || date == "") throw new NullPointerException("input date is null or empty!");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    public static String toStr(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Timestamp toTimestamp(Date date){
        return new Timestamp(date.getTime());
    }

    /**
     * 将String类型的日期转换成TimeStamp</br>
     * Tip：日期参数的格式类型，必须和format参数的格式一致，否则抛出ParseException
     * @param date - 日期
     * @param format - 格式化类型
     * @return Timestamp
     * @throws ParseException
     */
    public static Timestamp toTimestamp(String date,String format) throws ParseException{
        return toTimestamp(toDate(date, format));
    }

    public static String toStr(String date, String original_format,String transform_format) throws ParseException{
        return toStr(toDate(date, original_format), transform_format);
    }

    /**
     * 将Timestamp类型的日期根据输入的format的格式转换成Sting类型
     * @param timestamp  日期
     * @param format format格式
     * @return String
     */
    public static String toStr(Timestamp timestamp,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(timestamp);
    }

    public static String dateToStr(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Timestamp getBeginTimeOfDay(Date calBeginDate) throws ParseException {
        String date = dateToStr(calBeginDate, YYYY_MM_DD);
        date = date + " 00:00:00.000";
        return toTimestamp(date,YYYY_MM_DD_HH_MM_SS_SSS);
    }

    public static Timestamp getEndTimeOfDay(Date calBeginDate) throws ParseException {
        String date = dateToStr(calBeginDate, YYYY_MM_DD);
        date = date + " 23:59:59.999";
        return toTimestamp(date,YYYY_MM_DD_HH_MM_SS_SSS);
    }

    public static Date getFirstDayOfMonth(String date,String format){
        Date d = null;
        try {
            d = toDate(date, format);
            return calFirstDayOfMonth(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getFirstDayOfMonth(Date date){
        return calFirstDayOfMonth(date);
    }

    private static Date calFirstDayOfMonth(Date date) {
        Calendar firstDate = null;
        try {
            firstDate = Calendar.getInstance();
            firstDate.setTime(date);
            firstDate.set(Calendar.DATE,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstDate.getTime();
    }

    public static Date getLastDayOfMonth(String date, String format) {
        Date d = null;
        try {
            d = toDate(date, format);
            return calLastDayOfMonth(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getLastDayOfMonth(Date date){
        return calLastDayOfMonth(date);
    }

    private static Date calLastDayOfMonth(Date date) {
        Calendar lastDate = null;
        try {
            lastDate = Calendar.getInstance();
            lastDate.setTime(date);
            lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
            lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
            lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastDate.getTime();
    }

    public static int getDaysOfMonth(Date date){
        Calendar c= Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.valueOf(toStr(date,YYYY )));
        c.set(Calendar.MONTH, Integer.valueOf(toStr(date,MM ))-1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) throws ParseException{
        String date = "2014-09-02 00:00:00";
        String date2 = "2014-12-02 23:59:59";
        Date begin = DateUtils.getFirstDayOfMonth(date,DateUtils.YYYY_MM_DD_HH_MM_SS );
        Date end = DateUtils.getLastDayOfMonth(date2,DateUtils.YYYY_MM_DD_HH_MM_SS );
        System.out.println(begin);
        System.out.println(end);
        System.out.println(getDaysOfMonth(begin)+"");
    }
}
