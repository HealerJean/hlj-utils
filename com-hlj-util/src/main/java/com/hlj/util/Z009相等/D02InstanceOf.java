package com.hlj.util.Z009相等;

import org.junit.Test;

/**
 * @author HealerJean
 * @version 1.0v
 * @ClassName D02InstanceOf
 * @date 2019/5/13  14:16.
 * @Description
 */
public class D02InstanceOf {

    public  void instanceOf(Object object) {

        /**
         *  ==
         */
        if(Long.class == object.getClass()){
            System.out.println("Long.class == object.getClass()");
        }

        /**
         * equals
         */
        if(Long.class.equals(object.getClass()) ){
            System.out.println("Long.class.equals(object.getClass()) ");
        }

        /**
         * instance Of
         */
        if(object instanceof  Long){
            System.out.println("object instanceof  Long");
        }
    }

    /**
     * 测试类是否相当
     */
    @Test
    public  void test相等() {
        Long  object = 1100L;
        Integer va = 100;
        instanceOf(object) ;
        instanceOf(va) ;
    }


class  Father{}
class  Son extends  Father{}


    public void fatherAndSon(){
        Father son = new Son(); //和 Son son = new Son(); 一样
        Father father = new Father();

        //son.getClass() ==  father.getClass() :false
        System.out.println("son.getClass() ==  father.getClass() :" +(son.getClass() == father.getClass()) );

        //son.getClass().equals(father.getClass()) :false
        System.out.println("son.getClass().equals(father.getClass()) :" +(son.getClass().equals(father.getClass())) );

        //son  instanceof Father :true
        System.out.println("son  instanceof Father :" +(son  instanceof Father ));

        //father  instanceof Son :false   //父类不能  instanceof  子类
        System.out.println("father  instanceof Son :" +(father  instanceof Son ));

        //father  instanceof Father :true
        System.out.println("father  instanceof Father :" +(father  instanceof Father ));

        //son.getClass().isInstance(father):false  //子类不能 isInstance 父亲
        System.out.println("son.getClass().isInstance(father):"+son.getClass().isInstance(father));

        //father.getClass().isInstance(son):true
        System.out.println("father.getClass().isInstance(son):"+father.getClass().isInstance(son));

        //son.getClass().isInstance(son)true
        System.out.println("son.getClass().isInstance(son)"+son.getClass().isInstance(son));

    }

    @Test
    public void testFatherAndSon(){
        fatherAndSon();
    }


}
