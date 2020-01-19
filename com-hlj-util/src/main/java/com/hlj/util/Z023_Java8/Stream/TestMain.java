package com.hlj.util.Z023_Java8.Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HealerJean
 * @ClassName TestMain
 * @date 2019/11/25  11:46.
 * @Description
 */
public class TestMain {


    @Test
    public void testCollectingAndThan(){
        List<String> list = Arrays.asList("a", "b", "c");
        String str= list.stream().
                collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));

        System.out.println(str);
        // Collectors.joining(",")的结果是：a,b,c  然后再将结果 x + "d"操作, 最终返回a,b,cd

    }
}
