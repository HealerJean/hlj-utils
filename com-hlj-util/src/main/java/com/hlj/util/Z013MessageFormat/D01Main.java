package com.hlj.util.Z013MessageFormat;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * @author HealerJean
 * @version 1.0v
 * @ClassName D01Main
 * @date 2019/7/29  15:39.
 * @Description
 */
public class D01Main {

    /**
     新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。
     format(String format, Object... args)

     %s  字符串类型  "mingrisoft" ，也可以放入其他类型，比如，整数，小数等等
     %c  字符类型  'm'
     %b  布尔类型 true
     %d  整数类型（十进制） 99   %6d
     %.4f%%  小数  55.1510%
     */
    @Test
    public void strisngFormat(){

        String s ="____%s____";
        //____mingrisoft____
        System.out.println(String.format(s, "mingrisoft"));

        String c ="____%c____";
        //____c____
        System.out.println(String.format(c, 'c'));

        String b = "____%b____";
        //____true____
        System.out.println(String.format(b, true));

        String d = "____%d____";
        //____125____
        System.out.println(String.format(d, 125));

        String str = "____%s____"+ "____%c____"+"____%b____"+"____%d____" ;
        System.out.println(String.format(str, "mingrisoft",'c',true,123));
    }


    /**
     *
     */
    @Test
    public void format(){

        //1、展位
        String msg = "{0},{1},{2},{3},{4},{5},{6},{7},{8}";
        Object [] array = new Object[]{"A","B","C","D","E","F",1525.12,10,BigDecimal.ZERO};
        String value = MessageFormat.format(msg, array);
        // 输出：A,B,C,D,E,F,1,525.12,10,0
        System.out.println(value);


        // 2、格式化字符串时，两个单引号才表示一个单引号，单个单引号会被省略，除非中文单引号不会被省略，如：
         value = MessageFormat.format("oh, {0} is 'a' ''pig''", "ZhangSan");
        // oh, ZhangSan is a 'pig'
        System.out.println(value);

    }

}
