package com.hlj.util.Z005BiMap.bitset;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

/**
 * BitSet的应用场景  海量数据去重、排序、压缩存储
 * BitSet的基本操作   and（与）、or（或）、xor（异或）
 * Bitset，也就是位图，由于可以用非常紧凑的格式来表示给定范围的连续数据而经常出现在各种算法设计中。
 * 基本原理是，用1位来表示一个数据是否出现过，0为没有出现过，1表示出现过。使用用的时候既可根据某一个是否为0表示此数是否出现过。
 */
public class D01BitSet {


    /**
     * 给定一个的整数数组，请找到其中缺少的数字。
     */
    private void printMissingNumber(int[] numbers, int count) {
        System.out.println("一共有" + count + "个数据：目前数组为" + Arrays.toString(numbers));
        // 一共有10个数据：目前数组为[1, 2, 3, 4, 6, 9, 8]


        // 一共有多少数字,
        BitSet bitSet = new BitSet(count);
        // 将指定索引处的位设置为 true。
        for (int number : numbers) {
            bitSet.set(number - 1);
        }


        //一共丢失了多少位
        int missingCount = count - numbers.length;
        int lastMissingIndex = 0; // 索引从0开始
        for (int i = 0; i < missingCount; i++) {
            //返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    @Test
    public void start() {
        // 丢失3个数据
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // 丢失1个数据
        printMissingNumber(new int[]{1, 2, 3, 5}, 5);

    }


}
