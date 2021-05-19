package com.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author xiazhongwei02
 * @Date 2021-05-19$ xiazhongwei$
 **/
public class DateUtil {
    public static final long INTERVAL_UNIT = 1000L;
    public static final long MILLISECONDS_SECOND = 1000L;
    public static final long MILLISECONDS_MINUTE = 60000L;
    public static final long MILLISECONDS_HOUR = 3600000L;
    public static final long MILLISECONDS_DAY = 86400000L;
    public static final String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyy_MM = "yyyy-MM";
    public static final String yyyyMM = "yyyyMM";
    public static final String yyyy = "yyyy";
    public static final String HHmmssSSS = "HHmmssSSS";
    public static final String HHmmss = "HHmmss";
    public static final String HH_mm_ss = "HH:mm:ss";
    public static final String HH_mm = "HH:mm";

    private DateUtil() {
    }

    public static String getNowDate2String() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getNowDate2String(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String getDate2String(Date date) {
        return getDate2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDate2StringWithoutSecond(Date date) {
        return getDate2String(date, "yyyy-MM-dd HH:mm");
    }

    public static String getDate2String(Date date, String pattern) {
        return date == null ? "" : DateFormatUtils.format(date, pattern);
    }

    public static Date getString2Date(String dateStr) {
        return getString2Date(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getString2Date(String dateStr, String pattern) {
        try {
            return DateUtils.parseDate(dateStr, new String[]{pattern});
        } catch (ParseException var3) {
            return null;
        }
    }

    public static Long getDate2Long(Date date) {
        return date == null ? null : date.getTime();
    }

    public static Date getLong2Date(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    public static long getSecondTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public static long getSecondTime(Date date) {
        return date == null ? 0L : date.getTime() / 1000L;
    }

    public static long getMilliSecondsTime() {
        return System.currentTimeMillis();
    }

    public static long getMilliSecondsTime(Date date) {
        return date == null ? 0L : date.getTime();
    }

    public static String getTodayBegin2String() {
        return DateFormatUtils.format(getTodayBegin(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getTodayEnd2String() {
        return DateFormatUtils.format(getTodayEnd(), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getTodayBegin() {
        return getBegin4Date(new Date());
    }

    public static Date getTodayEnd() {
        return getEnd4Date(new Date());
    }

    public static String getBegin4Date2String(Date date) {
        return DateFormatUtils.format(getBegin4Date(date), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getEnd4Date2String(Date date) {
        return DateFormatUtils.format(getEnd4Date(date), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getBegin4Date(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getEnd4Date(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        return calendar.getTime();
    }

    public static String getMonthBegin2String() {
        return DateFormatUtils.format(getMonthBegin(), "yyyy-MM-dd");
    }

    public static String getMonthEnd2String() {
        return DateFormatUtils.format(getMonthEnd(), "yyyy-MM-dd");
    }

    public static Date getMonthBegin() {
        return getBegin4Month(new Date());
    }

    public static Date getMonthEnd() {
        return getEnd4Month(new Date());
    }

    public static String getBegin4Month2String(Date date) {
        return DateFormatUtils.format(getBegin4Month(date), "yyyy-MM-dd");
    }

    public static String getEnd4Month2String(Date date) {
        return DateFormatUtils.format(getEnd4Month(date), "yyyy-MM-dd");
    }

    public static String getTodayMonth2String() {
        return getMonth2String(new Date());
    }

    public static String getMonth2String(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM");
    }

    public static Date getBegin4Month(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, 0);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date getEnd4Month(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, 1);
        calendar.set(5, 0);
        return calendar.getTime();
    }

    public static String getYearBegin2String() {
        return DateFormatUtils.format(getYearBegin(), "yyyy-MM");
    }

    public static String getYearEnd2String() {
        return DateFormatUtils.format(getYearEnd(), "yyyy-MM");
    }

    public static Date getYearBegin() {
        return getBegin4Year(new Date());
    }

    public static Date getYearEnd() {
        return getEnd4Year(new Date());
    }

    public static String getBegin4Year2String(Date date) {
        return DateFormatUtils.format(getBegin4Year(date), "yyyy-MM");
    }

    public static String getEnd4Year2String(Date date) {
        return DateFormatUtils.format(getEnd4Year(date), "yyyy-MM");
    }

    public static String getTodayYear2String() {
        return getYear2String(new Date());
    }

    public static String getYear2String(Date date) {
        return DateFormatUtils.format(date, "yyyy");
    }

    public static Date getBegin4Year(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 0);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date getEnd4Year(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 11);
        calendar.set(5, 31);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static Date addDaysBegin(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static Date addDaysEnd(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static int diffDay(Date fromDate, Date toDate) {
        return (int)((toDate.getTime() - fromDate.getTime()) / 86400000L);
    }

    public static int diffDay(long fromTimeMs, long toTimeMs) {
        return (int)((toTimeMs - fromTimeMs) / 86400000L);
    }

    public static int diffHour(Date fromDate, Date toDate) {
        return (int)((toDate.getTime() - fromDate.getTime()) / 3600000L);
    }

    public static int diffHour(long fromTimeMs, long toTimeMs) {
        return (int)((toTimeMs - fromTimeMs) / 3600000L);
    }

    public static int diffMin(Date fromDate, Date toDate) {
        return (int)((toDate.getTime() - fromDate.getTime()) / 60000L);
    }

    public static int diffMin(long fromTimeMs, long toTimeMs) {
        return (int)((toTimeMs - fromTimeMs) / 60000L);
    }

    public static int diffSecond(Date fromDate, Date toDate) {
        return (int)((toDate.getTime() - fromDate.getTime()) / 1000L);
    }

    public static int diffSecond(long fromTimeMs, long toTimeMs) {
        return (int)((toTimeMs - fromTimeMs) / 1000L);
    }

    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.setTime(new Date());
        int day = calendar.get(7);
        return day - 1;
    }

    public static int getDayOfWeekCN() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.setTime(new Date());
        int day = calendar.get(7);
        return day == 1 ? 7 : day - 1;
    }

    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(5);
    }

    public static int getDayOfMonth() {
        return Calendar.getInstance().get(5);
    }

    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(2) + 1;
    }

    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(11);
    }

    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(12);
    }

    public static String getStringMonth(Date date) {
        return DateFormatUtils.format(date, "MM");
    }

    public static String getStringDate(Date date) {
        return DateFormatUtils.format(date, "dd");
    }

    public static String getStringHour(Date date) {
        return DateFormatUtils.format(date, "HH");
    }

    public static String getStringMinute(Date date) {
        return DateFormatUtils.format(date, "mm");
    }

    public static Date parse(String dateStr) {
        return parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parse(String dateStr, String pattern) {
        try {
            return DateUtils.parseDate(dateStr, new String[]{pattern});
        } catch (ParseException var3) {
            return null;
        }
    }

    public static String formatDateTime(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String formatTime(Date date) {
        return format(date, "HH:mm:ss");
    }

    public static String format(Date date, String pattern) {
        return date == null ? "" : DateFormatUtils.format(date, pattern);
    }

    public static boolean isBetween(Date date, Date start, Date end) {
        if (date != null && start != null && end != null && !start.after(end)) {
            return !date.before(start) && !date.after(end);
        } else {
            return false;
        }
    }
}
