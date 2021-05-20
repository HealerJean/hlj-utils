package com.hlj.util.z027_JavaUtils.list;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangyujin
 * @date 2021/5/20  4:22 下午.
 * @description
 */
@Slf4j
public class ListsMain {

    /**
     * 1、构建一个空的ArrayList
     */
    @Test
    public void newArrayList1(){
        List<Integer> list = Lists.newArrayList();
        log.info("list:{}", list );
    }

    /**
     * 2、直接创建
     */
    @Test
    public void newArrayList2(){
        List<String> list = Lists.newArrayList("a", "b");
        log.info("list:{}", list );
    }

    /**
     * 3、不可变的List
     */
    @Test
    public void test3(){
        List<String> list = ImmutableList.of("a", "b");
        log.info("list:{}", list );

        list.add("c");
        //抛出异常，因为是不可变的

    }


}
