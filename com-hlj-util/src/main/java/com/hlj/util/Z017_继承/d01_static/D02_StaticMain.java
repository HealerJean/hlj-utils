package com.hlj.util.Z017_继承.d01_static;

/**
 * @author HealerJean
 * @ClassName D02_StaticMain
 * @date 2019/11/12  15:41.
 * @Description
 */
public class D02_StaticMain {

    static{
        System.out.println("test class init!");
    }
    public static void main(String[] args){
        System.out.println(SubClass.s);
    }
}
