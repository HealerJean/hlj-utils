package com.hlj.util.z033_正则表达式;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyujin
 * @date 2022/1/21  2:08 下午.
 * @description
 */
public class TestMain {

    /**
     * 1、match.group
     */
    @Test
    public void test(){
        String line = "123ra9040 123123aj234 adf12322ad 222jsk22";
        ////d+ 表示最少匹配一个数字、[a-z]+ 表示最少匹配一个字符
        String pattern = "(\\d+)([a-z]+)(\\d+)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        int i = 0;
        // m.find 是否找到正则表达式中符合条件的字符串
        while (m.find( )) {
            // 拿到上面匹配到的数据
            System.out.println("----i="+i);
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
            i++;
            System.out.println("=============");
        }
    }
}
