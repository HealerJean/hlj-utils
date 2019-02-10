package com.hlj.util.designpatterns.Builder.Item;

import com.hlj.util.designpatterns.Builder.Packing.Packing;
import com.hlj.util.designpatterns.Builder.Packing.Wrapper;

/** 
 * @author : HealerJean
 * @date   ： 2017年11月21日 下午2:03:28 
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