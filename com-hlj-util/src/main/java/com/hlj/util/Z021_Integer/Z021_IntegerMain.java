package com.hlj.util.Z021_Integer;

import org.junit.Test;

/**
 * @author HealerJean
 * @ClassName Z021_IntegerMain
 * @date 2020/1/9  10:37.
 * @Description
 */
public class Z021_IntegerMain {


    /**
     * 1、两个 new Integer() 变量比较 ，永远是 false
     * 解释：生成的是堆内存对象，引用地址不相等 ，比较为false
     */
    @Test
    public void test1() {
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.print(i == j);  //false
    }

    /**
     * 2、Integer变量 和 new Integer() 变量比较 ，永远为 false。
     * 解释：而 new Integer() 的变量指向 堆中 新建的对象,Integer j = 100; -128到127，常量池，之外的也是堆中，但是和new 的不一样
     */
    @Test
    public void test2() {
        Integer i = new Integer(100);
        Integer j = 100;
        System.out.print(i == j);  //false 常量池和堆中的对象比较

        Integer i2 = new Integer(128);
        Integer j2 = 128;
        System.out.println(i2 == j2); //false 堆中建立的不同对象的比较
    }

    /**
     * 2、两个Integer 变量比较，如果两个变量的值在区间-128到127 之间，则比较结果为true，如果两个变量的值不在此区间，则比较结果为 false 。
     * 解释：java对于-128到127之间的数，会进行缓存。
     */
    @Test
    public void test3() {
        Integer i = 100;
        Integer j = 100;
        System.out.println(i == j); //true

        Integer i2 = 128;
        Integer j2 = 128;
        System.out.println(i2 == j2); //false
    }

    /**
     * 4、int 变量 与 Integer、 new Integer() 比较时，只要两个的值是相等，则为true
     * 解释：因为包装类Integer 和 基本数据类型int 比较时，java会自动拆包装为int ，然后进行比较，实际上就变为两个int变量的比较。
     ** 因为会把Integer自动拆箱为int再去比，也就是栈内存中的拆箱后进行比较**
     */
    @Test
    public void test4() {
        Integer i = new Integer(100);
        int j = 100;
        System.out.print(i == j); //true
    }


}
