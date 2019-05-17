package com.hlj.util.extend;



class A{
	// private String aString = "父亲变量";
	String aString = "父亲变量";
	public void aString(){
		System.out.println("父亲方法");
	}
}
public class D00变量 extends A{
	String aString = "儿子变量";
	public void aString(){
		aString = "方法儿子"; //没有改变string的值
		System.out.println("儿子方法");
	}
	public static void main(String[] args) {
		//多态
		System.out.println("*****多态******");
		A testB = new D00变量();
		System.out.println(testB.aString ); //父亲变量
		testB.aString();
		System.out.println("***********");

		D00变量 d00变量 = new D00变量();
		System.out.println(d00变量.aString );//儿子变量
		d00变量.aString() ;
	}
}
