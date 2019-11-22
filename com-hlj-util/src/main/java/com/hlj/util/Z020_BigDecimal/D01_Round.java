package com.hlj.util.Z020_BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author HealerJean
 * @ClassName D01_Round
 * @date 2019/11/22  14:39.
 * @Description 注意一定不要用浮点型，这样肯定会有损失
 */
public class D01_Round {


    /**
     * BigDecimal做除法的时候一定要在divide方法中传递第二个参数，定义精确到小数点后几位，否则在不整除的情况下，结果是无限循环小数时，就会抛出以上异常。
     * java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
     */
    @Test
    public void excepiton() {
        // BigDecimal result = new BigDecimal(1).divide(new BigDecimal(3));

        BigDecimal a = new BigDecimal(1) ;
        BigDecimal b = new BigDecimal(3) ;
        BigDecimal result = a.divide(b, 2,  BigDecimal.ROUND_HALF_UP);
        System.out.println(result);

    }

    /**
     * UP （个人理解：舍弃位前面 + 1）
     * 解释：始终对非零舍弃部分前面的数字加 1。
     * 注意，此舍入模式始终不会减少计算值的绝对值。
     */
    @Test
    public void UP() {
        BigDecimal result = null ;
        result = new BigDecimal("11.115").setScale(2, RoundingMode.UP) ;//11.12
        result = new BigDecimal("11.114").setScale(2, RoundingMode.UP); //11.12

        result = new BigDecimal("-11.115").setScale(2, RoundingMode.UP); //-11.12
        result = new BigDecimal("-11.114").setScale(2, RoundingMode.UP); //-11.12
        System.out.println(result);
    }

    /**
     * DOWN  (个人理解 ：舍弃位直接删除)
     * 解释 ：向零方向舍入 （即截尾）。
     * 注意，此舍入模式始终不会增加计算值的绝对值。
     */
    @Test
    public void DOWN() {
        BigDecimal result = null ;
        result =new BigDecimal("11.115").setScale(2, RoundingMode.DOWN); //11.11
        result =new BigDecimal("11.114").setScale(2, RoundingMode.DOWN); //11.11

        result =new BigDecimal("-11.115").setScale(2, RoundingMode.DOWN); //-11.11
        result =new BigDecimal("-11.114").setScale(2, RoundingMode.DOWN); //-11.11
        System.out.println(result);
    }

    /**
     * CEILING  (正数 UP、负数 DOWM )
     * 定义：向正无限大方向舍入。
     * 解释：如果结果为正，则舍入行为类似于 RoundingMode.UP；如果结果为负，则舍入行为类似于RoundingMode.DOWN。
     * 注意，此舍入模式始终不会减少计算值。
     */
    @Test
    public void CEILING() {
        BigDecimal result = null ;
        result =(new BigDecimal("11.115").setScale(2, RoundingMode.CEILING)); //11.12
        result =(new BigDecimal("11.114").setScale(2, RoundingMode.CEILING)); //11.12

        result =(new BigDecimal("-11.115").setScale(2, RoundingMode.CEILING)); //-11.11
        result =(new BigDecimal("-11.114").setScale(2, RoundingMode.CEILING)); //-11.11
        System.out.println(result);
    }

    /**
     * FLOOR （正数 DOWM，负数 UP）
     * 定义：向负无限大方向舍入。
     * 解释 ：如果结果为正，则舍入行为类似于 RoundingMode.DOWN；如果结果为负，则舍入行为类似于RoundingMode.UP
     * 注意，此舍入模式始终不会增加计算值。
     */
    @Test
    public void FLOOR() {
        BigDecimal result = null ;
        result =(new BigDecimal("11.115").setScale(2, RoundingMode.FLOOR)); //11.11
        result =(new BigDecimal("11.114").setScale(2, RoundingMode.FLOOR)); //11.11

        result =(new BigDecimal("-11.115").setScale(2, RoundingMode.FLOOR)); //-11.12
        result =(new BigDecimal("-11.114").setScale(2, RoundingMode.FLOOR)); //-11.12
        System.out.println(result);
    }


    /**
     * HALF_UP （四舍五入，负数先取绝对值再五舍六入，再负数）
     * 定义：向最接近的数字方向舍入，如果与两个相邻数字的距离相等，则向上舍入。。
     * 解释 ：如果被舍弃部分 >= 0.5，则舍入行为同 RoundingMode.UP；否则舍入行为同RoundingMode.DOWN。
     */
    @Test
    public void HALF_UP() {
        BigDecimal result = null ;
        result =(new BigDecimal("11.115").setScale(2, RoundingMode.HALF_UP)); //11.12
        result =(new BigDecimal("11.114").setScale(2, RoundingMode.HALF_UP)); //11.11

        result =(new BigDecimal("-11.115").setScale(2, RoundingMode.HALF_UP)); //-11.12
        result =(new BigDecimal("-11.114").setScale(2, RoundingMode.HALF_UP)); //-11.11
        System.out.println(result);
    }


    /**
     * HALF_DOWN （五舍六入，负数先取绝对值再五舍六入再负数）
     * 定义：向最接近的数字方向舍入，如果与两个相邻数字的距离相等，则向下舍入。
     * 解释 ：如果被舍弃部分 > 0.5，则舍入行为同 RoundingMode.UP；否则舍入行为同RoundingMode.DOWN。
     * 注意，此舍入模式就是通常讲的五舍六入。
     */
    @Test
    public void HALF_DOWN() {
        BigDecimal result = null ;
        result =(new BigDecimal("11.116").setScale(2, RoundingMode.HALF_DOWN)); //11.12
        result =(new BigDecimal("11.115").setScale(2, RoundingMode.HALF_DOWN)); //11.11
        result =(new BigDecimal("11.114").setScale(2, RoundingMode.HALF_DOWN)); //11.11

        result =(new BigDecimal("-11.116").setScale(2, RoundingMode.HALF_DOWN)); //-11.12
        result =(new BigDecimal("-11.115").setScale(2, RoundingMode.HALF_DOWN)); //-11.11
        result =(new BigDecimal("-11.114").setScale(2, RoundingMode.HALF_DOWN)); //-11.11
        System.out.println(result);
    }


    /**
     * HALF_EVEN
     *  1. 舍弃位的数字小于5时，该数字舍去；
     *  2. 舍弃位的数字大于5时，则进位；
     *  3. 舍弃位的数字等于5时，若5的后面还有不为“0”的任何数，则此时无论5的前面是奇数还是偶数，均应进位。
     *                          如果5后面为全部为“0”，要看5前面的数字，若是奇数则进位，若是偶数则将5舍掉；
     */
    @Test
    public void HALF_EVEN() {
        BigDecimal result = null ;
        //舍弃位的数字小于5时，该数字舍去；
        result =(new BigDecimal("1.114").setScale(2, RoundingMode.HALF_EVEN));// 1.11
        //舍弃位的数字大于5时，则进位；
        result =(new BigDecimal("1.116").setScale(2, RoundingMode.HALF_EVEN)); //1.12
        //若5的后面还有不为“0”的任何数，则此时无论5的前面是奇数还是偶数，均应进位。
        result =(new BigDecimal("1.1151").setScale(2, RoundingMode.HALF_EVEN)); //1.12
        result =(new BigDecimal("1.1251").setScale(2, RoundingMode.HALF_EVEN)); //1.13
        // 如果5后面为全部为“0”，要看5前面的数字，若是奇数则进位
        result =(new BigDecimal("1.1150").setScale(2, RoundingMode.HALF_EVEN)); // 1.12
        // 如果5后面为全部为“0” 要看5前面的数字,若是偶数则将5舍掉；
        result =(new BigDecimal("1.1250").setScale(2, RoundingMode.HALF_EVEN)); //1.12

        System.out.println(result);

    }

    /**
     * UNNECESSARY
     * 定义：用于断言请求的操作具有精确结果，因此不发生舍入。
     * 解释：计算结果是精确的，不需要舍入，否则抛出 ArithmeticException。
     */
    @Test
    public void UNNECESSARY (){
        BigDecimal result = null ;
        result =(new BigDecimal("1.11").setScale(2, RoundingMode.UNNECESSARY));
        //1.1 可以当做1.10 ，所以后面写2没毛病
        result =(new BigDecimal("1.1").setScale(2, RoundingMode.UNNECESSARY));

        //setScale 以后默认是RoundingMode.UNNECESSARY
        result =(new BigDecimal("1.11").setScale(2));

        //下面这个抛出异常 java.lang.ArithmeticException: Rounding necessary
        result =(new BigDecimal("1.111").setScale(2, RoundingMode.UNNECESSARY));


    }



}
