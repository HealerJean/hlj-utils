package com.hlj.util.Z008HashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author HealerJean
 * @Date 2018/4/12
 */
public class D02_Object {

    public static void main(String[] args) {
        Map <Object,Object> map = new HashMap<>();

        Object o = new Object();
        map.put(o,"Stromg");


        Object o2 = new Object();
        map.put(o2,3);


        System.out.println(map.get(o)); //Stromg
        System.out.println(map.get(o2)); //3

        o = 456;
        System.out.println(map.get(o)); //null  因为提供的key的hashcode的地址不是我们存储的地址，所以不能找到


        Person person = new Person();
        person.setAge(1);
        map.put(person,3);
        System.out.println(map.get(person)); //3

        person.setName("HealerJean");
        System.out.println(map.get(person)); //3
        System.out.println("map的大小"+map.size()); //map的大小3

        person = null ; // person设置为null， map中还是具有该person对象
        System.out.println(map.get(person));  //null
        System.out.println("map的大小"+map.size()); //map的大小3

        System.out.println("打印map的结果集");
        Object[] list = map.keySet().toArray();
        for (Object object :list){
            System.out.println("key="+object.toString()+"||||| value="+map.get(object).toString());
        }




        /**
         * Stromg
         * 3
         * null
         * 3
         * 3
         * map的大小3
         * null
         * map的大小3
         * 打印map的结果集
         * key=java.lang.Object@9807454||||| value=3
         * key=Person{age=1, name='HealerJean'}||||| value=3
         * key=java.lang.Object@4fca772d||||| value=Stromg
         */


    }


}

class Person {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

