package com.hlj.util.z031_泛型学习.origin;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author :HealerJean: 
 * @date   :2017��11��20�� ����2:45:44 
 * @Description: ��������������T�ͣ��ŵ����𣬵������T�Ļ� ����������Զ�T���в���
 * @param al    
 * void
 */
public class OneMain {
	
	/**
	 	? ��ʹ��
	 */
	public static void printColl(ArrayList<?> al){
        Iterator<?> it = al.iterator();
        while(it.hasNext())
        {
               System.out.println(it.next().toString());
        }
	}
	/**
		T ��ʹ�ã�����ֱ�ӵ�������ʹ��Ŷ������������Զ�T���в���
	 */
	public static <T> void printT(ArrayList<T> al){
        Iterator<T> it = al.iterator();
        while(it.hasNext())
        {
        	T it1 = it.next();
        	System.out.println(it1.toString());
        }
	}
	
	
}
