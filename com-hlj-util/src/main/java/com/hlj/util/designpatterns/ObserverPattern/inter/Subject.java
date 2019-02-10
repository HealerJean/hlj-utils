package com.hlj.util.designpatterns.ObserverPattern.inter;

import com.hlj.util.designpatterns.ObserverPattern.abstractClass.Observer;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author : HealerJean
 * @date   �� 2017��12��15�� ����2:28:08
 * @Description:  Subject ������а󶨹۲��ߵ� Client ����ʹ� Client ������۲��ߵķ���
 */


public class Subject {
    
   private List<Observer> observers  = new ArrayList<Observer>();

   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   /**
    * �󶨹۲��ߵ� Client ����
    * @param observer
    */
   public void attach(Observer observer){
      observers.add(observer);        
   }

   /**
    * �� Client ������۲��ߵķ���
    */
   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   }     
}
