package com.hlj.util.z027_JavaUtils.list.Lists;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyujin
 * @date 2021/11/11  4:00 下午.
 * @description
 */
@Slf4j
public class TestMain {

    /**
     * 1、构建一个空的ArrayList
     */
    @Test
    public void newArrayList1(){
        // 1
        List<Integer> list = Lists.newArrayList();
        log.info("list:{}", list );

        // 2
        list = Collections.emptyList();
        log.info("list:{}", list);
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
     * 3、set转list
     */
    @Test
    public void test3(){
        Set<String> set = Sets.newHashSet("a", "a", "b");
        List<String> list = Lists.newArrayList(set);
        log.info("list:{}", list );

    }


}
