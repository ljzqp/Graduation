package com.jxau.kknq.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 14:56
 */
public class DateUtils {

    /**
     * "yyyy-MM"
     */
    public static final String DI_FORMAT = "yyyy-MM";
    /**
     * "yyyy-MM-dd"
     */
    public static final String UI_FORMAT = "yyyy-MM-dd";
    /**
     * "yyyy-MM-dd HH:mm:ss"
     */
    public static final String EL_FORMAT = "yyyy-MM-dd HH:mm:ss";



    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    /** 锁对象 */
    private static final Object lockObj = new Object();
    
    private static final long oneHourMillSec = 60 * 60 * 1000;
    
    private static final long oneDayMillSec = 24 * oneHourMillSec;
    
    private static final long oneMonthMillSec = 30 * oneDayMillSec;

    
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }
        return tl.get();
    }
    
    
    public static Date parse(String str, String format) {
        try {
            return getSdf(format).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(Date date, String format) {
        return getSdf(format).format(date);
    }
    
    public static String format(long date, SimpleDateFormat format) {
        return format.format(date);
    }
    
    public static String format(long date, String format) {
        return getSdf(format).format(date);
    }

    public static int compare(String t1, String t2, String format) {
        return parse(t1, format).compareTo(parse(t2, format));
    }

    public static String formatAndEndOfDate(Date date, String format) {

        Date newDate = new Date(parse(getSdf(UI_FORMAT).format(date), UI_FORMAT)
                .getTime() + oneDayMillSec - 1);
        return getSdf(format).format(newDate);
    }
    
    public static String formatAndBeginOfDate(Date date, String format) {
        Date newDate = new Date(parse(getSdf(UI_FORMAT).format(date), UI_FORMAT).getTime());
        return getSdf(format).format(newDate);
    }

    public static String formatAndBeforeDate(Date date, String format) {
        Date newDate = new Date(parse(getSdf(UI_FORMAT).format(date), UI_FORMAT).getTime() - 1);
        return getSdf(format).format(newDate);
    }

    /**
     * 获取上个月的月份
     */
    public static String getLastMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return format(c.getTime(),DI_FORMAT);
    }

    /**
     * 获取上个月第一天
     */
    public static String getLastMonthFirstDay(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format(c.getTime(),format);
    }
    /**
     * 获取上个月第一天
     */
    public static String getLastMonthFirstDayBegin(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return format(c.getTime(),format);
    }
    /**
     * 获取前N个月第一天
     */
    public static String getLastNMonthFirstDay(Date date, String format, Integer n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format(c.getTime(),format);
    }
    /**
     * 获取前N个月第一天
     */
    public static Date getLastNMonthFirstDay(String dateString, String format, Integer n) {
        Date date = parse(dateString, format);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        String lastNMonthFirstDay = format(c.getTime(), format);
        return parse(lastNMonthFirstDay, format);
    }
    /**
     * 获取前N个月第一天
     */
    public static String getLastNMonthFirstDayString(String dateString, String format, Integer n) {
        Date date = parse(dateString, format);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format(c.getTime(),format);
    }
    /**
     * 获取上个月最后一天
     */
    public static String getLastMonthLastDay(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format(c.getTime(),format);
    }
    /**
     * 获取上个月最后一天
     */
    public static String getLastMonthLastDayEnd(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return format(c.getTime(),format);
    }
    /**
     * 获取前N个月最后一天 最后时刻
     */
    public static String getLastNMonthLastDay(Date date, String format, Integer n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MINUTE, 59);
        return format(c.getTime(), format);
    }
    /**
     * 获取前N个月最后一天 最后时刻
     */
    public static Date getLastNMonthLastDay(String dateString, String format, Integer n) {
        Date date = parse(dateString, format);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MINUTE, 59);

        return c.getTime();
    }
    /**
     * 获取前N个月最后一天
     */
    public static String getLastNMonthLastDayString(String dateString, String format, Integer n) {
        Date date = parse(dateString, format);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -n);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format(c.getTime(), format);
    }

    public static String getLastMonthDay(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return format(c.getTime(),EL_FORMAT);
    }
    
    public static Date getLastMonthDay(Date date){
        Date newDate = new Date(date.getTime() - oneMonthMillSec);
        return newDate;
    }
    
    public static Date getLastSixMonthDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -6);
        return cal.getTime();
    }
    
    public static Date getLastSixMonthFirstDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -6);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        return cal.getTime();
    }
    
    public static String getLastMonthDay(String date, String format) {
        Date  aday = parse(date, format);
        Calendar c = Calendar.getInstance();
        c.setTime(aday);
        c.add(Calendar.MONTH, -1);
        return format(c.getTime(),EL_FORMAT);

    }
    
    public static String getLastWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -7);
        return format(c.getTime(),EL_FORMAT);

    }

    public static Date getNextHour(Date date) {
        Date nextHour = new Date(date.getTime() + oneHourMillSec);
        return nextHour;
    }
    
    public static Date getNextNHour(Date date, int n) {
        Date nextHour = new Date(date.getTime() + n * oneHourMillSec);
        return nextHour;
    }
    
    public static Date getNextDay(Date date) {
        Date newDate = new Date(date.getTime() + oneDayMillSec);
        return newDate;
    }
    
    public static Date getNextNDay(Date date,int n) {
        Date newDate = new Date(date.getTime() + oneDayMillSec*n);
        return newDate;
    }

    public static Date getYesterday(Date date) {
        Date newDate = new Date(date.getTime() - oneDayMillSec);
        return newDate;
    }
    
    public static Date getYesterdayStartTime() {
        return getYesterday(getTodayStartTime());
    }
    
    public static Date getYesterdayLastSec() {
        return getPreSec(getTodayStartTime());
    }
    
    public static Date getPreSec(Date date) {
        return new Date(date.getTime()-1*1000);
    }
    /**
     * 两个时间的间隔天数(四舍五入)
     */
    public static int daysBetween(Date startDate, Date endDate) {
        float time = (float)(endDate.getTime() - startDate.getTime()) / oneDayMillSec;
        BigDecimal d = new BigDecimal(time);
        return d.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static List<String> getAllNHoursList(Date startTime, Date endTime, int n) {
        startTime = DateUtils.getStartTime(startTime);
        endTime = new Date(DateUtils.getStartTime(endTime).getTime() + oneDayMillSec -1);
        List<String> hours = new ArrayList<String>();
        hours.add(DateUtils.format(startTime, DateUtils.EL_FORMAT));
        Date nextHour = DateUtils.getNextNHour(startTime, n);
        while (nextHour.getTime() <= endTime.getTime()) {
            hours.add(DateUtils.format(nextHour, DateUtils.EL_FORMAT));
            nextHour = DateUtils.getNextNHour(nextHour,n);
        }
        System.out.println("DataUtils'hoursList:" + hours);
        return hours;
    }
    
    public static List<String> getAllDateList(Date startTime, Date endTime) {
        List<String> dates = new ArrayList<String>();

        dates.add(DateUtils.format(startTime, DateUtils.UI_FORMAT));
        Date nextDay = DateUtils.getNextDay(startTime);
        while (nextDay.getTime() <= endTime.getTime()) {
            dates.add(DateUtils.format(nextDay, DateUtils.UI_FORMAT));
            nextDay = DateUtils.getNextDay(nextDay);
        }

        return dates;
    }
    
    public static List<Date> getAllDateList(String startTimeString, String endTimeString) {
        List<Date> dates = new ArrayList<>();

        Date startTime = DateUtils.parse(startTimeString, DateUtils.UI_FORMAT);
        Date endTime = DateUtils.parse(endTimeString, DateUtils.UI_FORMAT);
        dates.add(startTime);
        Date nextDay = DateUtils.getNextDay(startTime);
        while (nextDay.getTime() <= endTime.getTime()) {
            dates.add(nextDay);
            nextDay = DateUtils.getNextDay(nextDay);
        }
        return dates;
    }
    
    public static List<String> getAllMonthList(Date startTime, Date endTime) {
        List<String> month = new ArrayList<String>();
        
        month.add(DateUtils.format(startTime, "yyyy-MM"));
        Date nextDay = DateUtils.getNextDay(startTime);
        while (nextDay.getTime() <= endTime.getTime()) {
            String m = DateUtils.format(nextDay, "yyyy-MM");
            if(!month.contains(m)) {
                month.add(m);
            }
            nextDay = DateUtils.getNextDay(nextDay);
        }
        return month;
    }
    
    public static List<String> getAllMonthMMList(Date startTime, Date endTime) {
        List<String> month = new ArrayList<String>();
        
        month.add(DateUtils.format(startTime, "MM"));
        Date nextDay = DateUtils.getNextDay(startTime);
        while (nextDay.getTime() <= endTime.getTime()) {
            String m = DateUtils.format(nextDay, "MM");
            if(!month.contains(m)) {
                month.add(m);
            }
            nextDay = DateUtils.getNextDay(nextDay);
        }
        return month;
    }
    
    public static String getYearWeekFirstDay(int yearNum,int weekNum)  {  
         Calendar cal = Calendar.getInstance();  
         cal.setFirstDayOfWeek(Calendar.MONDAY); //设置每周的第一天为星期一  
         cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//每周从周一开始  
         cal.setMinimalDaysInFirstWeek(7);  //设置每周最少为7天       
         cal.set(Calendar.YEAR, yearNum);  
         cal.set(Calendar.WEEK_OF_YEAR, weekNum);  
         return DateUtils.format(cal.getTime(),UI_FORMAT); 
    } 
    
    public static List<String> getAllWeekList(Date startTime, Date endTime) {
        List<String> week = new ArrayList<String>();
        int weekNum = getWeekNumberInThisYear(endTime);
        Calendar cl = Calendar.getInstance();
        cl.setTime(endTime);
        int year = cl.get(Calendar.YEAR);
        for(int i=1;i<weekNum;i++){
            week.add(getYearWeekFirstDay(year,i));
        }
        return week;
    }
    
    public static int getWeekNumberInThisYear(Date time)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(1);
        int i = c.get(Calendar.WEEK_OF_YEAR);
        if(i == 1) {
            c.setTime(parse(getLastWeekDay(time),UI_FORMAT));
        }
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    public static String getEndDateOfMonth(Date date) {// yyyy-MM-dd
        String dat = format(date, UI_FORMAT);
        String str = dat.substring(0, 8);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int lastDay =c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return str+lastDay;
    }
    
    public static String getStartDateOfMonth(Date date) {// yyyy-MM-dd
        String dat = format(date, UI_FORMAT);
        String str = dat.substring(0, 8);
        return str+"01";
    }
    
    public static String getStartDateOfWeek(Date date) {// yyyy-MM-dd
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format(c.getTime(), UI_FORMAT);
    }
    
    public static String getEndDateOfWeek(Date date) {// yyyy-MM-dd
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return format(c.getTime(), UI_FORMAT);
    }
    
    private static String appendZero4OneCh(int day)
    {
        String a = ""+day;
        if(a.length() == 1) {
            return "0"+a;
        } else {
            return a;
        }
    }
    
    public static String getNextMonthDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, +1);
        return format(c.getTime(),UI_FORMAT);
    }

    public static Date getNextMonthDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }
    
    public static String getNextWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_YEAR , +1);
        return format(c.getTime(),UI_FORMAT);
    }

    public static void main(String[] args)
    {
    
    
      System.out.println(getLastHour());
      System.out.println(getLastTwoHour());
        
    }
    

  public static String getTodayStart() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);

    return format(c.getTime(), EL_FORMAT);
  }
  
  public static Date getTodayStartTime() {

        return getStartTime(new Date());
  }
  
  public static Date getStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
  }

    public static Date getEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

  public static Date getLastHour() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.HOUR_OF_DAY, -1);
    return c.getTime();

  }

  public static Date getLastTwoHour() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.HOUR_OF_DAY, -2);
    return c.getTime();

  }
  
  public static String getTodayEnd() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    c.set(Calendar.MILLISECOND, 999);

    return format(c.getTime(), EL_FORMAT);
  }
  
  public static Date getLastYear(){
      Calendar c = Calendar.getInstance();
      c.setTime(new Date());
      c.add(Calendar.YEAR, -1);
      return c.getTime();
  }
  
    /**
     * 获取 指定日期 后 指定毫秒后的 Date
     *
     * @param date
     * @param millSecond
     * @return
     */
    public static Date getDateAddMillSecond(Date date, int millSecond) {
        Calendar cal = Calendar.getInstance();
        if (null != date) {// 没有 就取当前时间
            cal.setTime(date);
        }
        cal.add(Calendar.MILLISECOND, millSecond);
        return cal.getTime();
    }
    
    /**
     * 获取前days时间(整点）
     */
    public static Date getBeforeDate(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
    /**
     * 获取后days时间（整点）
     */
    public static Date getAfterDate(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
    /**
     * 获取某月的天数
     */
    public static int getDaysOfMonth(String dateString, String format) {
        Date date = parse(dateString, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取某月的天数
     */
    public static int getDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取当前日期的元月
     * 
     * @author zhangdongliang
     * @param dateString
     * @return
     */
    public static Date getJanuaryFromYear(String dateString) {
        Date date = parse(dateString, UI_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        
        return cal.getTime();
    }
    /**
     * 获取当前日期的元月
     */
    public static Date getJanuaryFromYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        
        return cal.getTime();
    }
    
    /**
     * 获取当前日期的二月
     */
    public static Date getFebruaryFromYear(String dateString) {
        Date date = parse(dateString, UI_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        
        return cal.getTime();
    }
    /**
     * 获取当前日期的元月
     */
    public static Date getFebruaryFromYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        
        return cal.getTime();
    }
    /**
     * 获取当月第一天 零时
     */
    public static String getFirstDayStartTimeOfMonth(String month) {
        Date startTime = DateUtils.parse(month, "yyyy-MM");
        return DateUtils.format(startTime, DateUtils.EL_FORMAT);
    }

    /**
     * 获取当月最后一天的最后时刻 "yyyy-MM-dd HH:mm:ss"
     * 如果月份为本月，则返回昨日最后时间
     */
    public static String getLastDayEndTimeOfMonth(String month) {
        String thisMonth = format(new Date(), "yyyy-MM");
        Date date = parse(month, "yyyy-MM");
        if(thisMonth.equals(month)) {
            Date yesterday = getYesterday(new Date());
            return formatAndEndOfDate(yesterday, EL_FORMAT);
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return format(c.getTime(), EL_FORMAT);
    }

    /**
     * 获取当月最后一天的零点 "yyyy-MM-dd HH:mm:ss"
     * 如果月份为本月，则返回昨日最后时间
     */
    public static String getLastDayStartTimeOfMonth(String month) {
        String thisMonth = format(new Date(), "yyyy-MM");
        Date date = parse(month, "yyyy-MM");
        if(thisMonth.equals(month)) {
            Date yesterday = getYesterday(new Date());
            return formatAndEndOfDate(yesterday, EL_FORMAT);
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        return format(c.getTime(), EL_FORMAT);
    }

}
