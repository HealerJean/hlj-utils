package com.hlj.util.Z006运算符;

import org.junit.Test;


/**
 * @Description
 * @Author HealerJean
 * @Date 2019/3/18  下午9:30.
 */
public class Z001位移运算符 {

    /**
     * 后面的数字代表移动几位
     */
    @Test
    public void 左移运算符(){
        int n = 10 ;
        System.out.println(Integer.toBinaryString(n)); //辗转相除法 1010

        // <<  左移运算符，相当于乘以 2 (二进制 加 一位)
        int l = n << 1 ;  //num << 1,
        System.out.println("n << 1 左移运算符"+l); //20
        l  = n  << 2 ;
        System.out.println("n << 2 左移运算符"+l);// 40

        // >> 右移运算符 ,相当于除以 2 （二进制 减 一位）
        int  r= n >> 1 ;
        System.out.println("n >> 1 右移运算符"+r); //5

        //res = 20 >>> 2; 的结果与 >> 相同；
        //无符号右移(忽略符号位，空位都以0补齐,不论是正数还是负数，都是补0)，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
    }

    @Test
    public void 异或运算符(){

        int s = 10 ;
        int e = 8 ;
        System.out.println(Integer.toBinaryString(s));
        System.out.println(Integer.toBinaryString(e));

        int y = s&e ;
        System.out.println("& 与运算："+y+" 二进制："+Integer.toBinaryString(y));

        int h = s|e ;
        System.out.println("| 或运算："+h+" 二进制："+Integer.toBinaryString(h));

        int yh =s^e ;
        //然后从高位开始比较，如果相同则为0，不相同则为1。
        System.out.println("^ 异或运算："+yh+" 二进制："+Integer.toBinaryString(yh));

        //在Java中，所有数据的表示方法都是以补码的形式表示，正数的补码是它本身，负数的补码是其绝对值的原码取反，末尾再加1。
        //如果没有特殊说明， Java中的数据类型默认是int,int数据类型的长度是8位，一位是四个字节，就是32bit
        //10 的二进制 其实 应该为 00000000 00000000 00000000 00001010
        //~s 运算规则：如果位为0，结果是1，如果位为1，结果是0.
        //                     11111111 11111111 11111111 11110101

        int f = ~s ;
        System.out.println("^ 非运算："+f+" 二进制："+Integer.toBinaryString(f));



    }


    


}
