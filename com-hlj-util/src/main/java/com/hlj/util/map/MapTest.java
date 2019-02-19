package com.hlj.util.map;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/8/9  ����11:57.
 */
public class MapTest {


    @Test
    public void testHashMap(){

        Map<String,Integer> hashMap = new HashMap<>() ;


        Map<String,Integer> hashTable = new Hashtable<>();


        Map<String,Integer>  concurrentHashMap = new ConcurrentHashMap<>() ;

    }

}
