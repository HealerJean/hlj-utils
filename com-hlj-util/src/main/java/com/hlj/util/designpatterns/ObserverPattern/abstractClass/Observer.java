package com.hlj.util.designpatterns.ObserverPattern.abstractClass;

import com.hlj.util.designpatterns.ObserverPattern.inter.Subject;

/** 
 * @author : HealerJean
 * @date   �� 2017��12��15�� ����2:28:58 
 * @Description:
 */
public abstract class Observer {
	   protected Subject subject;
	   public abstract void update();
	}