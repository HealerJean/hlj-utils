package com.hlj.util.Z009相等;

import org.junit.Test;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * D003ResolvableType
 *
 * @author zhangyujin
 * @date 2024/2/8
 */
public class D003ResolvableType {

    private HashMap<String, List<Integer>> param;


    @Test
    public void test() throws NoSuchFieldException {
        Type genericType = D003ResolvableType.class.getDeclaredField("param").getGenericType();
        ParameterizedType type = (ParameterizedType) genericType;
        Type[] typeArguments = type.getActualTypeArguments();
        System.out.println("从 HashMap<String, List<Integer>> 中获取 String:" + typeArguments[0]);
        // 从 HashMap<String, List<Integer>> 中获取 String:class java.lang.String

        System.out.println("从 HashMap<String, List<Integer>> 中获取 List<Integer> :" + typeArguments[1]);
        // 从 HashMap<String, List<Integer>> 中获取 List<Integer> :java.util.List<java.lang.Integer>

        System.out.println("从 HashMap<String, List<Integer>> 中获取 List :" + ((ParameterizedType) typeArguments[1]).getRawType());
        // 从 HashMap<String, List<Integer>> 中获取 List :interface java.util.List

        System.out.println("从 HashMap<String, List<Integer>> 中获取 Integer:" + ((ParameterizedType) typeArguments[1]).getActualTypeArguments()[0]);
        // 从 HashMap<String, List<Integer>> 中获取 Integer:class java.lang.Integer


        Field param = D003ResolvableType.class.getDeclaredField("param");
        System.out.println("从 HashMap<String, List<Integer>> 中获取父类型:"+param.getType().getGenericSuperclass());
        // 从 HashMap<String, List<Integer>> 中获取父类型:java.util.AbstractMap<K, V>
    }

    @Test
    public void test2() throws NoSuchFieldException {
        ResolvableType param = ResolvableType.forField(D003ResolvableType.class.getDeclaredField("param"));
        System.out.println("从 HashMap<String, List<Integer>> 中获取 String:" + param.getGeneric(0).resolve());
        // 从 HashMap<String, List<Integer>> 中获取 String:class java.lang.String

        System.out.println("从 HashMap<String, List<Integer>> 中获取 List<Integer> :" + param.getGeneric(1));
        // 从 HashMap<String, List<Integer>> 中获取 List :interface java.util.List

        System.out.println("从 HashMap<String, List<Integer>> 中获取 List :" + param.getGeneric(1).resolve());
        // 从 HashMap<String, List<Integer>> 中获取 List :interface java.util.List

        System.out.println("从 HashMap<String, List<Integer>> 中获取 Integer:" + param.getGeneric(1,0));
        // 从 HashMap<String, List<Integer>> 中获取 Integer:java.lang.Integer

        System.out.println("从 HashMap<String, List<Integer>> 中获取父类型:" +param.getSuperType());
        // 从 HashMap<String, List<Integer>> 中获取父类型:java.util.AbstractMap<java.lang.String, java.util.List<java.lang.Integer>>
    }

}
