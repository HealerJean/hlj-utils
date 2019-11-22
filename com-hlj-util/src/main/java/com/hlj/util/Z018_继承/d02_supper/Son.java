package com.hlj.util.Z018_继承.d02_supper;


public class Son extends Father {

	/**
	 * 一、无参构造器
	 *  1、写不写  	super(); 都会调用父类中的无参构造器
	 */

	public Son(){
		super();
		System.out.println( "Son  constructor");
		System.out.println("---------------------");
		//死循环 还会调用父类
		Son son = new Son();
	}

	/**
	 * 二、有参构造器
	 1、下面 写super() 和   super(str) 会调用父类中对应的构造器
	 2、不写 suppr时候，像无参构造器那样自动执行 父类中supper()
	 */

	public Son(String str){
		// 1、什么都不写会主动调用父类中的 supper()
		// 2、super(str); 会调用父类中的有参构造器 ，不会调用无参构造器
		super(str);
		System.out.println( "Son  param constructor");
		System.out.println("---------------------");
	}



	/**
	 * 三、不是构造器的方法
	 1、 super() 等 相同类型 只能用在构造器中
	 2、super.父类方法  可以放在任意方法的任意位置
	 */

	@Override
	public void otheMethod(){
		//super.otheMethod();
		System.out.println("Son  Test Son");
		//super.otheMethod();
		System.out.println("---------------------");
	}


}
