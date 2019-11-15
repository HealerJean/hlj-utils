package com.hlj.util.Z017_继承.d02_supper;

import org.junit.Test;


public class D02_SuperMain {

	@Test
	public  void testSupperFatherConstrustor() {
		Son son = new Son();
		Father father = new Son();
	}

	@Test
	public void testSupperFatherParamConstrustor() throws Exception {
		String str  = "HealerJean";
		Father fatherParam = new Son(str);

	}

	@Test
	public void testOtherMethod() {
		Father fatherParam = new Son();
		fatherParam.otheMethod();
	}

}
