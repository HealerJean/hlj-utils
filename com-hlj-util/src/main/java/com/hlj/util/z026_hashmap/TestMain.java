package com.hlj.util.z026_hashmap;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HealerJean
 * @ClassName TestMain
 * @date 2020/4/27  14:44.
 * @Description
 */
public class TestMain {


    @Test
    public void test(){

        // ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        // concurrentHashMap.put("1", "1");
        // concurrentHashMap.put("1", "2");

        HashMap hashMap = new HashMap(2);
        hashMap.put("1",null);
        hashMap.put("2",null);
        hashMap.put("3",null);
        hashMap.put("4",null);
        System.out.println(hashMap.put("1",2));

        System.out.println(hashMap.remove("1"));
        Map hashtable = new Hashtable();





    }
}

