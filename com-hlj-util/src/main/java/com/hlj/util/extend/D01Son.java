package com.hlj.util.extend;

/**
 * @author HealerJean
 * @version 1.0v
 * @Description
正常环境下, 把一个父类转换成子类一定会损失精度.  但是如果父类对象本身就是用
 子类去new出来的, 就类似于一个本来就是儿子角色的人, 去装了一会儿父亲, 这个角色是可以在未来转换回去的,
但是一个父亲, 永远不可能去装儿子的.
 * @ClassName D01SonAndFather
 * @date 2019/4/16  20:33.
 */
class D01Father {

    public int fint = 1 ;

    public String fString = "父变量" ;

}

public class D01Son extends D01Father{

    public int sint = 1 ;

    public String sString = "儿子变量" ;

    public String son1Name ;

    public static void main(String[] args) {

        //父类 引用指向子类，（如果使用子类对象，则变量必须强制转化）,不会丢失子类的数据
        D01Father father = new D01Son() ;
        //必须隐式转化
        System.out.println(((D01Son) father).sString);

        //父类 强制 转化为子类 //报异常，父亲不能直接转化为子类，
//        D01Son son = (D01Son)new D01Father();
//        System.out.println(son.fString);



        //子类  之间 不可以  互相转化

         father = new D01Son() ;
         System.out.println(((D02Son) father) .sint);

    }
}

class D02Son extends D01Father{

    public int sint = 2 ;

    public String sString = "儿子变量" ;

    public String son2Name ;
}