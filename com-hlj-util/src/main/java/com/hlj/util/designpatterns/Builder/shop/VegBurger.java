package com.hlj.util.designpatterns.Builder.shop;

import com.hlj.util.designpatterns.Builder.Item.Burger;

/** 
 * @author : HealerJean
 * @date   ： 2017年11月21日 下午2:04:45 
 * @Description:
 */
public class VegBurger extends Burger {

	   @Override
	   public float price() {
	      return 25.0f;
	   }

	   @Override
	   public String name() {
	      return "Veg Burger";
	   }
}