package com.hlj.util.designpatterns.FacadePattern.inter.impl;

import com.hlj.util.designpatterns.FacadePattern.inter.Shape;


/** 
 * @author : HealerJean
 * @date   ： 2017年12月15日 下午1:49:30 
 * @Description:
 */
public class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Square::draw()");
	   }
}

