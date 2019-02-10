package com.hlj.util.designpatterns.ObserverPattern.abstractClass;

import com.hlj.util.designpatterns.ObserverPattern.inter.Subject;

/** 
 * @author : HealerJean
 * @date   ： 2017年12月15日 下午2:28:58 
 * @Description:
 */
public abstract class Observer {
	   protected Subject subject;
	   public abstract void update();
	}