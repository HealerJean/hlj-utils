package com.hlj.util.Z018_继承.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author HealerJean
 * @ClassName D01_ExtentMain
 * @date 2019/11/12  15:31.
 * @Description
 */
@Slf4j
public class D01_ExtentMain {

    /**
     * 子类继承自父类的变量，其实是相当于复制了一个副本
     */
    @Test
    public void test1(){
        Father father = new Son();
        log.info("father.name：【{}】", father.name);
        //  父亲
        log.info("father.printName：【{}】", father.printName());
        //  父亲
        log.info("father.printGetName：【{}】", father.printGetName());
        //  父亲
        log.info("--------");


        father.name = "father = name";
        log.info("father.name：【{}】", father.name);
        //  【father = name】
        log.info(" ((Son) father).name：【{}】", ((Son) father).name);
        //  【father = name】
        log.info("father.getName：【{}】", father.getName());
        //  【father = name】
        log.info("father.printName：【{}】", father.printName());
        //  【father = name】
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【father = name】
        log.info("--------");


        father.setName("father set name");
        log.info("father.name：【{}】", father.name);
        //  【father set name】
        log.info("father.name：【{}】", ((Son) father).name);
        //  【father set name】
        log.info("father.getName：【{}】", father.getName());
        //  【father set name】
        log.info("father.printName：【{}】", father.printName());
        //  【father set name】
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【father set name】
        log.info("--------");




        Son son = new Son();
        son.name = "son == name" ;

        //子类强制转化为父类
        father = son;
        log.info("father.name：【{}】", father.name);
        //  【父亲】
        log.info("father.name：【{}】", ((Son) father).name);
        //  【son == name】
        log.info("father.getName：【{}】", father.getName());
        //  【son == name】
        log.info("father.printName：【{}】", father.printName());
        //  【son == name】
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【son == name】
        log.info("--------");


    }


    /**
     *  1、子类中声明了和父类名称一样的变量，则子类中对自己声明的变量的修改，不影响父类中改变量的值
     *  2、 变量直接赋值（=）（son.name   father.name），改变的自己的变量值或者是父类的变量值，
     *     如果setName，肯定是看被实例化的对象是谁，那就给自己赋值啊，因为调用的方法肯定是自己内部的。
     */
    @Test
    public void test2() {

        Father father = new Son();
        log.info("father.name：【{}】", father.name);
        //  【父亲】 （这个变量是父类的）
        log.info("father.printName：【{}】", father.printName());
        //  【儿子】 (方法是子类的)
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【儿子】 (方法是子类的)
        log.info("--------");


        //1、父类中有变量名，所以改变的是父类中的变量
        father.name = "father = name";
        log.info("father.name：【{}】", father.name);
        //  【father = name】     //父类中的属性
        log.info(" ((Son) father).name：【{}】", ((Son) father).name);
        //  【儿子】 （强制转化成了子类，因为子类中有该属性,所以打印的是子类的变量的值）
        log.info("father.getName：【{}】", father.getName());
        //  【儿子】（方法是子类的）
        log.info("father.printName：【{}】", father.printName());
        //  【儿子】（方法是子类的）
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【儿子】（方法是子类的）
        log.info("--------");

        //2、子类中有方法，所以 调用的是子类的方法，子类的name值改变了，父类没有改变
        father.setName("father set name");
        log.info("father.name：【{}】", father.name);
        //  【father = name】    子类中声明了和父类名称一样的变量，则子类中对自己声明的变量的修改，不影响父类中变量的值
        log.info("father.name：【{}】", ((Son) father).name);
        //  【father set name】 （强制转化成了子类，因为子类中有该属性,所以打印的是子类的变量的值）
        log.info("father.getName：【{}】", father.getName());
        //  【father set name】
        log.info("father.printName：【{}】", father.printName());
        //  【father set name】
        log.info("father.printGetName：【{}】", father.printGetName());
        //  【father set name】
        log.info("--------");

    }





}
