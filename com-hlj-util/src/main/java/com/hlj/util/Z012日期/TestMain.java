package com.hlj.util.Z012日期;

import com.hlj.util.Z012日期.D02Date.DateHelper;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangyujin
 * @date 2022/5/19  15:22.
 * @description
 */
public class TestMain {

    public static Date getDayBeginTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDayEndTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Test
    public void test(){
        String curDate ="2022-01-01 01:12:00";
        Date date = DateHelper.toDate(curDate, DateHelper.YYYY_MM_DD_HH_MM_SS);
        String dateStr = DateHelper.toDateString(getDayEndTime(date), DateHelper.YYYY_MM_DD_HH_MM_SS);
        System.out.println(dateStr);
    }
}
