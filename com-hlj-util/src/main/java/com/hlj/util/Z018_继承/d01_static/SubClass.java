package com.hlj.util.Z018_继承.d01_static;

/**
 * @author HealerJean
 * @ClassName SubClass
 * @date 2019/11/12  15:40.
 * @Description
 */
public class SubClass extends SuperClass{
    static{
        System.out.println("SubClass init!");
    }
    public final static int s = 2; //对于静态字段，只有指定定义这个字段的类才会初始化
}
