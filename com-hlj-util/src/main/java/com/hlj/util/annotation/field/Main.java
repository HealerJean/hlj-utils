package com.hlj.util.annotation.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/** 
 * @author : HealerJean
 * @date   ： 2017年12月27日 下午4:40:56 
 * @Description:
 */
public class Main {
	
	public static void main(String[] args) {
		Field[] fields = FieldEntry.class.getDeclaredFields();
		for(Field field :fields){
			for(Annotation annotation:field.getAnnotations()){
				System.out.println(annotation.toString());
			}
		}
	}
}
