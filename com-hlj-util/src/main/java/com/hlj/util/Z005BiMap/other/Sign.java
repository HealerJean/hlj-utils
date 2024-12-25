package com.hlj.util.Z005BiMap.other;

import java.util.*;

/**
 * @author zhangyujin
 * @date 2022/6/30  18:15.
 */
public class Sign {

    //int最多可以容纳32位，0b表示需jdk1.8+支持,左边第一位永远为0，即正整数，无日期含义；右边31位表示日期，从左到右1-31天
    private final static int monthSignRecord = 0b01111111111111111111111111111000;
    private final static int DAY28 = 0x7ffffff8;
    private final static int DAY29 = 0x7ffffffc;
    private final static int DAY30 = 0x7ffffffe;
    private final static int DAY31 = 0x7fffffff;
    private final static int MONTH_MODEL = 0x40000000;
    private final static Calendar CALENDAR = Calendar.getInstance(Locale.CHINA);

    /**
     * 签到总数
     *
     * @param holder 签到记录
     * @return
     */
    public static int signCount(int holder) {
        return Integer.bitCount(holder);
    }

    /**
     * 获取指定月是否全签到
     *
     * @param holder 签到记录
     * @return
     */
    public static boolean isSignFullInFixedMonth(int holder, int month) {
        CALENDAR.set(Calendar.MONTH, month - 1);
        int days = CALENDAR.getActualMaximum(Calendar.DATE);

        switch (days) {
            case 28:
                return (holder & DAY28) == DAY28;
            case 29:
                return (holder & DAY29) == DAY29;
            case 30:
                return (holder & DAY30) == DAY30;
            case 31:
                return (holder & DAY31) == DAY31;
        }
        throw new IllegalArgumentException("month is illegal");
    }

    /**
     * 获取指定月漏签次数
     *
     * @param holder 签到记录
     * @return
     */
    public static int unSignCountInFixedMonth(int holder, int month) {
        // java 月份从0开始算，因此传入的月份需要减去1
        CALENDAR.set(Calendar.MONTH, month - 1);
        return CALENDAR.getActualMaximum(Calendar.DATE) - Integer.bitCount(holder);
    }

    /**
     * 指定天是否签到
     *
     * @param holder   当前签到标识
     * @param position 签到天标识位
     * @return
     */
    public static boolean isSignInFixedDay(int holder, int position) {
        return (holder & position) == position;
    }

    /**
     * 按照天签到
     *
     * @param holder   当前签到标识
     * @param position 签到天标识位
     * @return 新签到标识
     */
    public static int signInFixedDay(int holder, int position) {
        if (isSignInFixedDay(holder, position)) {
            return holder;
        }
        return holder | position;
    }

    /**
     * 批量签到，适合补签场景
     *
     * @param holder 当前签到标识
     * @param days   批量签到序号
     * @return 新签到标识
     */
    public static int batchSign(int holder, List<Integer> days) {
        Iterator<Integer> it = days.iterator();
        while (it.hasNext()) {
            holder = holder | getPosition(it.next());
        }
        return holder;
    }

    public static int getPosition(int position) {
        //0b01000000000000000000000000000000 == 0x40000000 左边第一位永远为0，即正整数，无日期含义；右边31位表示日期，从右到左1-31天
        return MONTH_MODEL >>> (position - 1);
    }

    public static void main(String[] args) {
        int month = 5;
        System.out.printf("签到记录：【%s】 %n", Integer.toBinaryString(monthSignRecord));
        // 签到记录：【1111111111111111111111111111000】

        System.out.printf("签到总数：【%d】 %n", signCount(monthSignRecord));
        // 签到总数：【28】

        System.out.printf("%d月漏签总数 %d %n", month, unSignCountInFixedMonth(monthSignRecord, month));
        // 5月漏签总数 3

        System.out.printf("全月是否全部签到 %b %n", isSignFullInFixedMonth(monthSignRecord, month));
        // 全月是否全部签到 false

        System.out.printf("签到前【%s】%n", Integer.toBinaryString(monthSignRecord));
        // 签到前【1111111111111111111111111111000】

        int signTemp = signInFixedDay(monthSignRecord, getPosition(30));
        signTemp = signInFixedDay(signTemp, getPosition(31));
        System.out.printf("签到后【%s】%n", Integer.toBinaryString(signTemp));
        // 签到后【1111111111111111111111111111011】

        System.out.printf("全月是否全部签到 %b %n", isSignFullInFixedMonth(signTemp, month));
        // 全月是否全部签到 false

        System.out.printf("批量签到前【%s】%n", Integer.toBinaryString(monthSignRecord));
        // 批量签到前【1111111111111111111111111111000】

        int signBatch = batchSign(monthSignRecord, Arrays.asList(29, 30, 31));
        System.out.printf("批量签到后【%s】%n", Integer.toBinaryString(signBatch));
        // 批量签到后【1111111111111111111111111111111】

        System.out.printf("全月是否全部签到 %b %n", isSignFullInFixedMonth(signBatch, month));
        // 全月是否全部签到 true
    }
}