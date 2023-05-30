package com.hlj.util.Z005BitSet;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyujin
 * @date 2022/6/30  18:02.
 */
@Slf4j
public class StatusEnums {
    private final static long INIT = 1L << 0;
    private final static long CHSI_VERIFY = 1L << 1;
    private final static long GRADUATE = 1L << 2;

    static {
        System.out.println(Long.toBinaryString(INIT));
        System.out.println(Long.toBinaryString(CHSI_VERIFY));
        System.out.println(Long.toBinaryString(GRADUATE));
        System.out.println();
    }


    /**
     * 是否包含状态
     *
     * @param holder   当前状态
     * @param position 标志位状态
     * @return
     */
    public static boolean hasStatus(long holder, long position) {
        return (holder & position) == position;
    }

    /**
     * 添加状态
     *
     * @param holder   当前状态
     * @param position 添加状态标志位
     * @return 新状态
     */
    public static long addStatus(long holder, long position) {
        if (hasStatus(holder, position)) {
            return holder;
        }
        return holder | position;
    }

    /**
     * 移除状态
     *
     * @param holder   当前状态
     * @param position 移除状态标志位
     * @return 新状态
     */
    public static long removeStatus(long holder, long position) {
        if (!hasStatus(holder, position)) {
            return holder;
        }
        //异或移除
        return holder ^ position;
    }

    public static void main(String[] args) {
        long holder = 7L;
        System.out.println(Long.toBinaryString(holder));
        //0111

        System.out.println(StatusEnums.hasStatus(holder, INIT));
        // true -> 0001 在 0111 中
        System.out.println(StatusEnums.hasStatus(holder, CHSI_VERIFY));
        // true -> 0010 在 0111 中
        System.out.println(StatusEnums.hasStatus(holder, GRADUATE));
        // tuue -> 0100 在 0111 中

        holder = StatusEnums.removeStatus(holder, INIT);
        holder = StatusEnums.removeStatus(holder, CHSI_VERIFY);
        holder = StatusEnums.removeStatus(holder, GRADUATE);
        System.out.println(Long.toBinaryString(holder));
        //0000
        System.out.println(StatusEnums.hasStatus(holder, INIT));
        // false -> 0001 不在 0111 中
        System.out.println(StatusEnums.hasStatus(holder, CHSI_VERIFY));
        // false -> 0010 不在 0111 中
        System.out.println(StatusEnums.hasStatus(holder, GRADUATE));
        // false -> 0100 不在 0111 中

    }
}