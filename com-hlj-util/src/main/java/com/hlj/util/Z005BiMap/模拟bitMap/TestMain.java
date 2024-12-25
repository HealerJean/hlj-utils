package com.hlj.util.Z005BiMap.模拟bitMap;

import org.junit.Test;

/**
 * TestMain
 *
 * @author zhangyujin
 * @date 2024/9/14
 */
public class TestMain {


    @Test
    public void test(){
        CompressedBitmap bitmap = new CompressedBitmap(64);
        bitmap.add(63);
        System.out.println(bitmap.get(63));
        // 1
        System.out.println(bitmap.get(64));
        // 0
        System.out.println(bitmap.get(2));
        // 0
    }

}
