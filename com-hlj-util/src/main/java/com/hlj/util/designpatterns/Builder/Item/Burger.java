package com.hlj.util.designpatterns.Builder.Item;

import com.hlj.util.designpatterns.Builder.Packing.Packing;
import com.hlj.util.designpatterns.Builder.Packing.Wrapper;

/** 
 * @author : HealerJean
 * @date   �� 2017��11��21�� ����2:03:28 
 * @Description:
 */
public abstract class Burger implements Item {

	   @Override
	   public Packing packing() {
	      return new Wrapper();
	   }

	   @Override
	   public abstract float price();
}