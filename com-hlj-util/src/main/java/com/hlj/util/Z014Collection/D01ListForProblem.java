package com.hlj.util.Z014Collection;

/**
 * @author HealerJean
 * @ClassName D01ListForProblem
 * @date 2019-08-04  21:29.
 * @Description
 */
public class D01ListForProblem {


    // ArrayList、LinkedList、HashMap中都有一个字段叫modCount。这个字段的用途
    // 该字段被Iterator以及ListIterator的实现类所使用，如果该值被意外更改，Iterator或者ListIterator 将抛出ConcurrentModificationException异常，
    //         1、在ArrayList中有个成员变量modCount，继承于AbstractArrAayList
    // 数，每对List对象修改一次，也就每次add或者remove它的值都会加1.
    //         Itr类里有一个成员变量expectedModCount，它的值为创建Itr对象的时候List的modCount值。
    // 用此变量来检验在迭代过程中List对象是否被修改了，如果被修改了则抛出java.util.ConcurrentModificationException异常。
    // 在每次调用Itr对象的next()或者remove方法的时候都会调用checkForComodification()方法进行一次检验，
    // checkForComodification()方法中做的工作就是比较expectedModCount 和modCount的值是否相等，如果不相等，
    // 就认为还有其他对象正在对当前的List进行操作，那个就会抛出ConcurrentModificationException异常。
    //
    // 将list对象里面的“c"删除了，同时list对象的modCount值加1，但是Itr对象的expectedModCount没有变，他们肯定是不相等了。等再一次执行next()方法的时候调用了checkForComodification()方法，这时候就抛出异常了。


    

}
