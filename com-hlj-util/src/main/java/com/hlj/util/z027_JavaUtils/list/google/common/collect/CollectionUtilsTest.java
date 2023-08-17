package com.hlj.util.z027_JavaUtils.list.google.common.collect;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * CollectionUtilsTest
 *
 * @author zhangyujin
 * @date 2023/5/22  09:50.
 */
public class CollectionUtilsTest {


    /**
     * 用于检查给定的 Collection 对象是否可能包含任何公共元素；不存在公共元素时返回true，否则返回false。
     */
    @Test
    public void test1() {
        String[] arrayA = new String[]{"1", "2", "3", "4"};
        String[] arrayB = new String[]{"3", "4", "5", "6"};
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        System.out.println(CollectionUtils.containsAny(listA, listB));
    }



    @Test
    public void test2(){

        String[] array = {"Java", "Python", "C++"};
        List list = org.springframework.util.CollectionUtils.arrayToList(array);
        System.out.println(list);
    }

}
