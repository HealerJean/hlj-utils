package com.hlj.util.extend;

/**
 * 父类中的变量是子类共享的，如果没有覆盖的话
 */
class SimleCale {
public int value;
	public void calculate(){
		value+=7;
	} 

}

public class MultiCale extends SimleCale{
	public void calculate(){
		System.out.println( value);//0
		value-=3;
		System.out.println( value);//-3
	}
	public void calculate(int multiplier){
			calculate(); 
			super.calculate(); //4 /
			value*=multiplier; //8
		}
public static void main(String[] args) {
	MultiCale calculatorCale = new MultiCale();
	calculatorCale.calculate(2);
	System.out.println("Values is "+calculatorCale.value);
}
}
