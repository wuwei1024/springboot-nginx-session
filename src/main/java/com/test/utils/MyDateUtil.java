package com.test.utils;

import java.util.Calendar;

/**
 * 时间处理的工具类
 *
 * @author wuwei
 * @date 2017-12-22
 */
public class MyDateUtil {
    /**
     * 返回每个月第一天的开始时间
     *
     * @param month
     * @return
     */
    public static long getStartTimeByMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1,
                0, 0, 0);
        cal.add(Calendar.MONTH, month);
        return cal.getTimeInMillis();
    }

    /**
     * 返回每个月最后一天的结束时间
     *
     * @param month
     * @return
     */
    public static long getEndTimeByMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1,
                23, 59, 59);
        cal.add(Calendar.MONTH, month + 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTimeInMillis();
    }

    /**
     * 返回几天前的开始时间
     *
     * @param day
     * @return
     */
    public static long getStartTime(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTimeInMillis();
    }

    /**
     * 返回几天前的结束时间
     *
     * @param day
     * @return
     */
    public static long getEndTime(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTimeInMillis();
    }
}
