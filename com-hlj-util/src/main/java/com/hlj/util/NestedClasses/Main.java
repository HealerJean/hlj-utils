package com.hlj.util.NestedClasses;

import com.hlj.util.NestedClasses.StaticAndNoStaticClass.NoStaticClass;

/** 
 * @author : HealerJean
 * @date   �� 2017��12��14�� ����1:48:24 
 * @Description:
 */
public class Main {
	public static void main(String[] args) {
		//���� ��̬�ڲ��� ����ֱ��new����
		//NoStaticClass noStaticClass = new NoStaticClass();
		
		NoStaticClass noStaticClass = new StaticAndNoStaticClass().new NoStaticClass();
		noStaticClass.display();
	}
}
