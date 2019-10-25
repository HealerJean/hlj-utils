package com.hlj.util.Z015Map详解.d01_jdk17_HashMap;

import com.hlj.util.Z009相等.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HealerJean
 * @ClassName Z015_D01Main
 * @date 2019/10/11  16:42.
 * @Description
 */
public class Z015_D01Main {


    static final int MAXIMUM_CAPACITY = 1 << 30;


    @Test
    public void test(){
        Map map = new HashMap();
        int cap = 16 ;
            int n = cap - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);

        map.put("a","111");
        System.out.println(map.put("a" , "222"));
        System.out.println(map.put("b" , "bbb"));

    }

    @Test
    public void comparePeople(){
        People people =  new People();
        people.setId(1);
        people.setUsername("HealerJean");

        People people2 =  new People();
        people2.setId(1);
        people2.setUsername("HealerJean");

        System.out.println(compareComparables(People.class, people , people2));

    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) // 如果x是个字符串对象
                return c; // 返回String.class
            /*
             * 为什么如果x是个字符串就直接返回c了呢 ? 因为String  实现了 Comparable 接口，可参考如下String类的定义
             * public final class String implements java.io.Serializable, Comparable<String>, CharSequence
             */
            // 如果 c 不是字符串类，获取c直接实现的接口（如果是泛型接口则附带泛型信息）
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) { // 遍历接口数组
                    // 如果当前接口t是个泛型接口
                    // 如果该泛型接口t的原始类型p 是 Comparable 接口
                    // 如果该Comparable接口p只定义了一个泛型参数
                    // 如果这一个泛型参数的类型就是c，那么返回c
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType) t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
                // 上面for循环的目的就是为了看看x的class是否 implements  Comparable<x的class>
            }
        }
        return null; // 如果c并没有实现 Comparable<c> 那么返回空
    }


    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }
}
