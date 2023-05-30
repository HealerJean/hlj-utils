package com.hlj.util.Z005BitSet;

/**
 * @author zhangyujin
 * @date 2022/9/17  12:41.
 */
public class BitMap {
    /**
     * 用 byte 数组存储数据
     */
    private byte[] bits;
    /**
     * 指定 bitMap的长度
     */
    private int bitSize;


    /**
     * bitmap构造器
     *
     * @param bitSize bitSize
     */
    public BitMap(int bitSize) {
        this.bitSize = (bitSize >> 3) + 1;
        //1byte 能存储8个数据，那么要存储 bitSize的长度需要多少个bit呢，bitSize/8+1,右移3位相当于除以8
        bits = new byte[(bitSize >> 3) + 1];
    }


    /**
     * 在bitmap中插入数字
     *
     * @param num
     */
    public void add(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;
        // num%8得到在byte[index]的位置
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        bits[arrayIndex] |= 1 << position;
    }

    /**
     * 判断bitmap中是否包含某数字
     *
     * @param num
     * @return
     */
    public boolean contain(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;
        // num%8得到在byte[index]的位置
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[arrayIndex] & (1 << position)) != 0;
    }

    /**
     * 清除bitmap中的某个数字
     *
     * @param num
     */
    public void clear(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;
        // num%8得到在byte[index]的位置
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);
    }

    /**
     * 打印底层bit存储
     *
     * @param bitMap
     */
    public static void printBit(BitMap bitMap) {
        int index = bitMap.bitSize & 0x07;
        for (int j = 0; j < index; j++) {
            System.out.print("byte[" + j + "] 的底层存储：");
            byte num = bitMap.bits[j];
            for (int i = 7; i >= 0; i--) {
                System.out.print((num & (1 << i)) == 0 ? "0" : "1");
            }
            System.out.println();
        }
    }

    /**
     * 输出数组元素，也可以使用Arrays的toString方法
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        System.out.print("数组元素：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}