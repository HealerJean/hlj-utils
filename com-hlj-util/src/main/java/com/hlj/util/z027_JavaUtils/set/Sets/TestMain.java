package com.hlj.util.z027_JavaUtils.set.Sets;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author zhangyujin
 * @date 2021/11/11  4:05 下午.
 * @description
 */
@Slf4j
public class TestMain {

    /**
     * 1、构建一个空的Set
     */
    @Test
    public void test1(){
        Set<String> set = Sets.newHashSet();
    }

    /**
     * 2、构建有值的Set
     */
    @Test
    public void test2(){
        Set<String> set = Sets.newHashSet("a", "a", "b");
        log.info("set:{}", set);
    }


    /**
     * 3、list转Set
     */
    @Test
    public void test3(){
        List<String> list = Lists.newArrayList("a", "a", "b");
        Set<String> set = Sets.newHashSet(list);
        log.info("set:{}", set);
    }


}
