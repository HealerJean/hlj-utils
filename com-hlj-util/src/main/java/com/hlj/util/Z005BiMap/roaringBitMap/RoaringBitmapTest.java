package com.hlj.util.Z005BiMap.roaringBitMap;

import org.junit.Test;
import org.roaringbitmap.RoaringBitmap;

/**
 * RoaringBitmap
 *
 * @author zhangyujin
 * @date 2024/9/13
 */
public class RoaringBitmapTest {


    @Test
    public void test() {
        // 创建两个 RoaringBitmap 实例
        RoaringBitmap bitmap1 = new RoaringBitmap();
        RoaringBitmap bitmap2 = new RoaringBitmap();

        // 向 bitmap1 添加元素
        bitmap1.add(1);
        bitmap1.add(100);
        bitmap1.add(1000);

        // 向 bitmap2 添加元素
        bitmap2.add(100);
        bitmap2.add(200);
        bitmap2.add(1000);


        // 执行交集操作
        RoaringBitmap intersection = RoaringBitmap.and(bitmap1, bitmap2);
        System.out.println("Intersection: " + intersection); // 应该包含 100 和 1000
        // Intersection: {100,1000}

        // 执行差集操作 (bitmap1 - bitmap2)
        RoaringBitmap difference = RoaringBitmap.andNot(bitmap1, bitmap2);
        System.out.println("Difference (bitmap1 - bitmap2): " + difference); // 应该只包含 1
        // Difference (bitmap1 - bitmap2): {1}

        // 检查元素是否存在
        boolean contains100 = bitmap1.contains(100);
        System.out.println("Does bitmap1 contain 100? " + contains100); // 输出 true
        // Does bitmap1 contain 100? true

        // 输出 bitmap1 的内容
        System.out.println("Bitmap1: " + bitmap1);
        // Bitmap1: {1,100,1000}
    }


}
