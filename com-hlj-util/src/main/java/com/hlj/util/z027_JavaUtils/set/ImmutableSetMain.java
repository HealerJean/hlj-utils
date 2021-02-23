package com.hlj.util.z027_JavaUtils.set;

import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Set;

/**
 * @author zhangyujin
 * @date 2021/2/23  8:09 下午.
 * @description
 */
@Slf4j
public class ImmutableSetMain {

    @Test
    public void test() {
        Set<String> immutalbleSet = ImmutableSet.of("A", "B", "C");
        log.info("ImmutableSet.of ={}" , immutalbleSet);
        //ImmutableSet.of =[A, B, C]

        immutalbleSet.add("C");
        //抛出异常，因为是不可变的
    }
}
