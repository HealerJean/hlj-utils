package com.hlj.util.Z018_继承.d02_supper;


public class Father {

	public Father(){
		System.out.println("Father  constructor");
	}

	public Father(String str){
		System.out.println("Father   Param constructor "+ str);
	}

	public void otheMethod(){
		System.out.println("Father Method");
	}
}
