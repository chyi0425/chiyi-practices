package com.chiyi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chiyi
 */
public class TimeUtil {
    private static Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    public static final String FORAMT_STR_HH = "HH";
    public static final String FORAMT_STR_mm = "mm";
    public static final String FORAMT_STR_HH_mm = "HH:mm";
    public static final String FORAMT_STR_yyyyMM = "yyyyMM";
    public static final String FORAMT_STR_yyyyMMdd = "yyyyMMdd";
    public static final String FORAMT_STR_yyyyMMddHH = "yyyyMMddHH";
    public static final String FORAMT_STR_yyyyMMddHHmm = "yyyyMMddHHmm";
    public static final String FORAMT_STR_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String FORAMT_STR_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String FORAMT_STR_yyyy_MM_dd_kk_mm_ss_SSS = "yyyy-MM-dd kk:mm:ss.SSS";
    public static final String FORAMT_STR_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String FORAMT_STR_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String FORAMT_STR_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String FORMAT_STR_MMdd = "MMdd";

    public static Date string2Data(String dateStr,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("[DateTimeUtil][stringToDate]:" + e.toString());
        }
        return date;
    }

    public static Date addDays(Date date, int num) {
        Calendar dateTem = Calendar.getInstance();
        dateTem.setTime(date);
        dateTem.add(Calendar.DATE, num);
        return dateTem.getTime();
    }

    public static Date addMonths(Date date, int amount) {
        return add(date, 2, amount);
    }

    private static void validateDateNotNull(Date date) {
        Validate.isTrue(date != null, "The date must not be null", new Object[0]);
    }

    private static Date add(Date date, int calendarField, int amount) {
        validateDateNotNull(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    public static void main(String[] args) {
//        Date date = string2Data("201702",FORAMT_STR_yyyyMM);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar.getTime());
//        int nums = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println(addDays(date,nums-1));
//
//        int[] roomIds = new int[500];
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i= 0;i<500;i++){
//            roomIds[i]=i+1;
//            stringBuilder.append(i+1).append("_").append(200).append(",");
//        }
//        System.out.println(stringBuilder.toString());
        List<Long> monthUnixTimestamp = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));


        for(Date start = calendar.getTime();start.getTime()<new Date().getTime();){
            monthUnixTimestamp.add(start.getTime()/1000);
            start = TimeUtil.addMonths(start,1);
        }

        System.out.println(monthUnixTimestamp.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm");
        simpleDateFormat.format(new Date());
        System.out.println(simpleDateFormat.format(new Date()));
    }

}
