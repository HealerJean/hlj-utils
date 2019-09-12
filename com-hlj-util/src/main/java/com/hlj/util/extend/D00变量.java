package com.hlj.util.extend;


import lombok.Data;
@Data
class A{

	public String aString = "父亲变量";

	public void setaString(String aString){
		this.aString = aString ;
	}

	public void aString(){
		System.out.println("父亲方法");
	}
}
@Data
public class D00变量 extends A{

	public String aString = "儿子变量";


	@Override
	public void aString(){
		System.out.println(aString+"儿子方法");
	}


	public static void main(String[] args) {
		//多态
		System.out.println("*****多态******");
		A testA = new D00变量();
		System.out.println(testA.aString ); //父亲变量
		testA.setaString("setAstig"); //setAstig
		System.out.println(testA.aString);
		testA.aString();
		System.out.println("***********");

		D00变量 d00变量 = new D00变量();
		System.out.println(d00变量.aString );//儿子变量
		d00变量.aString() ;
	}
}
