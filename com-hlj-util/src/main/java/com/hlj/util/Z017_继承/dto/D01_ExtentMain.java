package com.hlj.util.Z017_继承.dto;

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
     * 子类继承自父类的变量，其实是相当于复制了一个副本，不会改变父类自身变量的值（不同于static变量，static是全局的）
     * 直接== 赋值和 set变量赋值结果是一样的
     */
    @Test
    public void test1(){
        Father father = new Son();
        log.info("father.name：【{}】", father.name); //【父亲】

        Son son = new Son();
        son.name = "son = name";
        log.info("son.name：【{}】", son.name); //son = name
        log.info("son.getName：【{}】", son.getName()); //son = name
        log.info("son.printName：【{}】", son.printName()); //son = name
        log.info("son.printGetName：【{}】", son.printGetName()); //son = name

        log.info("--------");
        //子类继承自父类的变量，其实是相当于复制了一个副本，不会改变父类自身变量的值（不同于static变量，static是全局的）
        log.info("father.name：【{}】", father.name); //【父亲】
        log.info("father.getName：【{}】", father.getName()); //【父亲】
        log.info("father.printName：【{}】", father.printName()); //【父亲】
        log.info("father.printGetName：【{}】", father.printGetName()); //【父亲】

        son.setName("son set name");
        log.info("son.name：【{}】", son.name); //son set name
        log.info("son.getName：【{}】", son.getName());//son set name
        log.info("son.printName：【{}】", son.printName());//son set name
        log.info("son.printGetName：【{}】", son.printGetName());//son set name
    }


    /**
     *  1、子类中声明了和父类名称一样的变量，则子类中对自己声明的变量的修改，不影响父类中改变量的值
     *  2、变量直接赋值（son.name   father.name），改变的自己的变量值或者是父类的变量值，如果setName，肯定是看被实例化的对象是谁，那就给自己赋值啊，因为调用的方法肯定是自己内部的。
     */
    @Test
    public void test2() {

        Father father = new Son();
        log.info("father.name：【{}】", father.name);
        // log: 父亲 （这个变量是父类的）
        log.info("father.printName：【{}】", father.printName());
        // log: 儿子 (方法是子类的)
        log.info("father.printGetName：【{}】", father.printGetName());
        // log: 儿子 (方法是子类的)
        log.info("--------");


        // 下面修父类的变量
        father.name = "father = name";
        log.info("father.name：【{}】", father.name);
        // log: father = name //父类中的属性
        log.info("father.name：【{}】", ((Son) father).name);
        // log: 儿子 （强制转化成了子类，因为子类中有该属性,所以打印的是子类的变量的值）
        log.info("father.getName：【{}】", father.getName());
        // log: 儿子（方法是子类的）
        log.info("father.printGetName：【{}】", father.printGetName());
        // log: 儿子（方法是子类的）
        log.info("father.printName：【{}】", father.printName());
        // log: 儿子（方法是子类的）
        log.info("--------");


        // 子类中声明了和父类名称一样的变量，则子类中对自己声明的变量的修改，不影响父类中变量的值
        father.setName("father set name");
        log.info("father.name：【{}】", father.name);
        // log: father = name
        log.info("father.name：【{}】", ((Son) father).name);
        // log: father set name （强制转化成了子类，因为子类中有该属性,所以打印的是子类的变量的值）
        log.info("father.getName：【{}】", father.getName());
        // log: father set name（方法是子类的）
        log.info("father.printGetName：【{}】", father.printGetName());
        // log: father set name（方法是子类的）
        log.info("father.printName：【{}】", father.printName());
        // log: father set name（方法是子类的）
        log.info("--------");

        Son son = new Son();
        son.name = "test";
        log.info("son.name：【{}】", son.name);
        // log：test
        log.info("son.name：【{}】", son.getName());
        // log：test
        log.info("son.printName：【{}】", son.printName());
        // log：test
        log.info("son.printGetName：【{}】", son.printGetName());
        // log：test

    }





}
