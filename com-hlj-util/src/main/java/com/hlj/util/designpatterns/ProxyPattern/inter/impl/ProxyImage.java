package com.hlj.util.designpatterns.ProxyPattern.inter.impl;

import com.hlj.util.designpatterns.ProxyPattern.inter.Image;

/** 
 * @author : HealerJean
 * @date   ?? 2017??12??15?? ????2:08:31
 * @Description:
 */
public class ProxyImage implements Image{

	   private RealImage realImage;
	   private String fileName;

	   public ProxyImage(String fileName){
	      this.fileName = fileName;
	   }
 
	   @Override
	   public void display() {
	      if(realImage == null){
	         realImage = new RealImage(fileName);
	      }
	      realImage.display();
	   }
}
