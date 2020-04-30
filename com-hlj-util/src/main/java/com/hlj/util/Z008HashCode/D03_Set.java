package com.hlj.util.Z008HashCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试 set
 */
public class D03_Set {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
 /*
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof D03_Set)) {
            return false;
        }
        D03_Set other = (D03_Set) object;
        if (other.getI() == this.getI()) {
            return true;
        }
        return false;
    }  */
    @Override
    public int hashCode() {
        return 1;
    }

    /**
     *  对象的内存地址与hashcode有关系，但并不是hashcode值相等，就是代表内存地址相同，这种想法是幼稚的
     *  比如hashtable中hashcode值相等，
     *  	但是存了很多的对象，这表明对象的== 肯定不相等，Ojbect逆向推理，equals不相等，==肯定不相等
     *
     */
    @Test
    public void test1(){
        D03_Set a1 = new D03_Set();
        D03_Set a2 = new D03_Set();
        D03_Set a3 = new D03_Set();
        D03_Set a4 = new D03_Set();
        D03_Set a5 = new D03_Set();
        D03_Set a6 = new D03_Set();
        D03_Set a7 = new D03_Set();
        D03_Set a8 = new D03_Set();
        D03_Set a9 = new D03_Set();
        D03_Set a10 = new D03_Set();
        D03_Set a11 = new D03_Set();
        D03_Set a12 = new D03_Set();
        D03_Set a13 = new D03_Set();
        D03_Set a14 = new D03_Set();
        D03_Set a15 = new D03_Set();
        D03_Set a16 = new D03_Set();

        ConcurrentHashMap<D03_Set, String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(a1 , "1");
        concurrentHashMap.put(a2 , "2");
        concurrentHashMap.put(a3 , "3");
        concurrentHashMap.put(a4 , "4");
        concurrentHashMap.put(a5 , "5");
        concurrentHashMap.put(a6 , "6");
        concurrentHashMap.put(a7 , "7");
        concurrentHashMap.put(a8 , "8");
        concurrentHashMap.put(a9 , "9");
        concurrentHashMap.put(a10, "10");
        concurrentHashMap.put(a11, "11");
        concurrentHashMap.put(a12, "12");
        concurrentHashMap.put(a13, "13");
        concurrentHashMap.put(a14, "14");
        concurrentHashMap.put(a15, "15");



    }



    @Test
    public void test2(){
        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add(new String("abc"));
        System.out.println(set.size()); //1


        Map map = new HashMap();
        map.put("abc", "ab");
        map.put(new String("abc"), "ab");
        System.out.println(map.size()); //1

    }
}
