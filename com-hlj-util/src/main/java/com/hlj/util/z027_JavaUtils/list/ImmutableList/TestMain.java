package com.hlj.util.z027_JavaUtils.list.ImmutableList;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangyujin
 * @date 2021/11/11  4:00 下午.
 * @description
 */
@Slf4j
public class TestMain {

    /**
     * 1、不可变的List
     */
    @Test
    public void test3(){
        // 1、
        List<String> list = ImmutableList.of("a", "b");
        log.info("list:{}", list );

        list.add("c");
        //抛出异常，因为是不可变的

        //2、
        List<String> strList2 = Collections.singletonList("A");
        strList2.add("B");
        log.info("strList2:{}", strList2 );
        //抛出异常，因为是不可变的
    }
}
