package com.hlj.util.annotation.method;

import java.lang.annotation.*;


/** 
 * @author : HealerJean
 * @date   �� 2017��12��27�� ����3:20:12 
 * @Description:
 */
/*
@Retention(RetentionPolicy.RUNTIME) // ע�����class�ֽ����ļ��д��ڣ�������ʱ����ͨ�������ȡ��  
@Target({})//����ע�������Ŀ��**���÷�Χ�ֶΡ�ö�ٵĳ���/����  
@Documented//˵����ע�⽫��������javadoc��
*/
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
	    String author() default "Pankaj";
	    String date(); //û���ṩĬ��ֵ���������ֵ
	    int revision() default 1;
	    String comments();
	    String value() default ""; //���ֻ�����ע�⣬��ֱ��    @MethodInfo("Healerjean");
}
