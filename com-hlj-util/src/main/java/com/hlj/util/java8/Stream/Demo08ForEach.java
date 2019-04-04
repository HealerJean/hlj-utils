package com.hlj.util.java8.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc: ForEach 如果希望对流当中的元素，进行逐一挨个处理，
 * 可以使用ForEach方法，参数是一个Consumer接口(方法，lambda，方法引用)
 * @Author HealerJean
 * @Date 2018/9/14  上午11:48.
 */
public class Demo08ForEach {

    @Test
    public void demo(){
        List<String> list = new ArrayList<>();
        list.add("赵丽颖");
        list.add("张宇晋");
        list.add("赵春宇");
        list.add("林铁");
        list.add("杜闯");
        list.add("高彤");
        list.add("张翠翠");
        list.add("张三丰");

        list.stream().forEach(s->{
            System.out.println(s);

            methodConsume();//非静态
             Demo08ForEach:;methodConsume();

            methodStaticConsume();//静态
            Demo08ForEach:;methodStaticConsume();

        });

        list.stream().forEach(System.out::println);
    }

    public void methodConsume(){
        System.out.println("高手在民间");
    }




    public static void methodStaticConsume(){
        System.out.println("静态高手在民间");
    }


    @Test
    public void remove(){

        LinkedList<Long> orderIds  =new LinkedList<>();
        orderIds.add(1L);
        orderIds.add(2L);
        orderIds.add(3L);

        List<Long> ids = new ArrayList<>() ;

        int i ;
        for(i=0;i<=2;i++){
                ids.add( orderIds.getFirst());
                orderIds.removeFirst();
        }

        System.out.println(ids);
        System.out.println(orderIds);

    }


    /**
     * for 循环不能终止
     *
     * 它里面有一个消费者，消费者里面 结束了，但是不能结束for，使用return则是进行下一个数据进行消费
     *    default void forEach(Consumer<? super T> action) {
     *         Objects.requireNonNull(action);
     *         for (T t : this) {
     *             action.accept(t);
     *         }
     *     }
      */
    @Test
    public void continueForeach(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");



        list.forEach(s->{
            if(StringUtils.equals("a",s )){
              return; //这里的return 相当于continue没有结束循环，而是继续下一个
            }
            System.out.println(s);

        });

        System.out.println("-------------------");
        list.stream().forEach(s->{
            if(StringUtils.equals("a",s )){
                return; //这里的return 相当于continue没有结束循环，而是继续下一个
            }
            System.out.println(s);
        });


    }



}
