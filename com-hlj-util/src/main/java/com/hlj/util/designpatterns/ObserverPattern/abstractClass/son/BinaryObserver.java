package com.hlj.util.designpatterns.ObserverPattern.abstractClass.son;

import com.hlj.util.designpatterns.ObserverPattern.abstractClass.Observer;
import com.hlj.util.designpatterns.ObserverPattern.inter.Subject;

/** 
 * @author : HealerJean
 * @date   �� 2017��12��15�� ����2:29:58 
 * @Description:
 */
public class BinaryObserver extends Observer{

	   public BinaryObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Binary String: " 
	      + Integer.toBinaryString( subject.getState() ) ); 
	   }
	}