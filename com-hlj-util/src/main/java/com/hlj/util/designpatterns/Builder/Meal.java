package com.hlj.util.designpatterns.Builder;
/** 
 * @author : HealerJean
 * @date   ： 2017年11月21日 下午2:06:08 
 * @Description:
 */

import com.hlj.util.designpatterns.Builder.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
   private List<Item> items = new ArrayList<Item>();    

   public void addItem(Item item){
      items.add(item);
   }

   public float getCost(){
      float cost = 0.0f;
      for (Item item : items) {
         cost += item.price();
      }        
      return cost;
   }

   public void showItems(){
      for (Item item : items) {
         System.out.print("Item : "+item.name());
         System.out.print(", Packing : "+item.packing().pack());
         System.out.println(", Price : "+item.price());
      }        
   }    
}