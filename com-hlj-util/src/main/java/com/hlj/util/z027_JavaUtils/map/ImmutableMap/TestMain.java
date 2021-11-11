package com.hlj.util.z027_JavaUtils.map.ImmutableMap;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author zhangyujin
 * @date 2021/11/11  4:00 下午.
 * @description
 */
@Slf4j
public class TestMain {

    @Test
    public void test() {
        Map<String, String> map = ImmutableMap.of("keyA", "A", "keyB", "B");
        log.info("ImmutableMap.of = {}", map);
        //ImmutableMap.of = {keyA=A, keyB=B}

        map.put("keyN" ,"N");
        //抛出异常，因为是不可变的
    }


}
