package com.hlj.util.designpatterns.FacadePattern.inter.impl;

import com.hlj.util.designpatterns.FacadePattern.inter.Shape;


/** 
 * @author : HealerJean
 * @date   �� 2017��12��15�� ����1:49:30 
 * @Description:
 */
public class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Square::draw()");
	   }
}

