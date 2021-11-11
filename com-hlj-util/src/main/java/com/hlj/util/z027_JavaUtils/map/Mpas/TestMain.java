package com.hlj.util.z027_JavaUtils.map.Mpas;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author zhangyujin
 * @date 2021/11/11  3:58 下午.
 * @description
 */
@Slf4j
public class TestMain {

    /**
     * 1、创建一个空的Map
     */
    @Test
    public void test(){
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "HealerJean");
        log.info("map:{}", map);
    }




}
