package com.hlj.util.Z014Collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author HealerJean
 * @date 2020/12/3  11:25.
 * @description
 */
public class D03_LinkedList {

    @Test
    public void test(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.remove("a");

    }
}
