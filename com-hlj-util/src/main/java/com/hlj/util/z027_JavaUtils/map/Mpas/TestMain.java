package com.hlj.util.z027_JavaUtils.map.Mpas;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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


    /**
     * 2、computeIfAbsent
     */
    @Test
    public void test02(){
        Map<String, List<String>> map = Maps.newHashMap();
        map.put("a", Lists.newArrayList("aVal"));
        //  "a" 已经存在，    则追加 "aNewVal" 到list中
        map.computeIfAbsent("a", (v) -> new ArrayList<>()).add("aNewVal");

        //  "b" 不存在，     则创建新List "aNewVal" 到list中
        map.computeIfAbsent("b", (v) -> new ArrayList<>()).add("bVal");
        System.out.println(map);

        //  "c" valul null， 则创建新List "aNewVal" 到list中
        map.put("c", null);
        map.computeIfAbsent("c", (v) -> new ArrayList<>()).add("cVal");
        System.out.println(map);

        // {a=[aVal, aNewVal], b=[bVal], c=[cVal]}
    }

    /**
     * 3、putIfAbsent
     */
    @Test
    public void test03(){
        Map<String,String> map = Maps.newHashMap();
        map.put("a", "aVal");
        // "a"已经存在，则不会覆盖
        map.putIfAbsent("a", "aNewVal");


        // "b"不存在，则放入
        map.putIfAbsent("b", "bVal");

        // "c" value null，则放入
        map.put("c", null);
        map.putIfAbsent("c", "cVal");
        System.out.println(map);
        // {a=aVal, b=bVal, c=cVal}
    }



}
