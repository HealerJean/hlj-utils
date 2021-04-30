package com.hlj.util.z031泛型学习.origin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author : HealerJean
 * @date   �� 2017��11��20�� ����2:50:52 
 * @Description: 2���������������
 */
public class TwoMain {
	
	public static  void main(String[] args) {
		//listAddDifParam(); 
	//	testEquals();
		invokeMethod();
	}
	/**
	 list ��Ӳ�ͬ���͵Ĳ���������ᱨ�� 
	 */
	private static void listAddDifParam() {
		List list = new ArrayList();  
		list.add("CSDN_SEU_Cavin");  
		list.add(100);  
		for (int i = 0; i < list.size(); i++) {  
		  String name = (String) list.get(i); //ȡ��Integerʱ������ʱ�����쳣  
		System.out.println("name:" + name);  
		}
	}
	/**
	 * 
	 * ���з���Ĳ�������������ʱ�ģ�����ʹ��class����֤���ԣ���
	 * 	���Ϊ��Java�б�����class�������������Ϣ
	 * ��ȻΪtrue����֤���˱���֮�� ������ȡȥ���ͻ��Ĵ�ʩ��Ҳ����˵Java�еķ��ͣ�ֻ�ڱ���׶���Ч
	 * �ɹ���������class�ļ����ǲ������κη�����Ϣ�ġ�������Ϣ������뵽����ʱ�׶Ρ�
	 */
	private static void testEquals() {
		ArrayList<String> a = new ArrayList<String>();  
		ArrayList b = new ArrayList();  
		Class c1 = a.getClass();  
		Class c2 = b.getClass();  
		
		System.out.println(c1 == c2); //true   ��ʾ�Ѿ�����������
	}
	
	
	/**
	 * 
	 * @author :HealerJean: 
	 * @date   :2017��11��20�� ����1:09:10 
	 * @Description:
	 * @param al   ʹ�÷��� 
	 * void ��֤ listAddDifParam �� testEquals �е�����
	 */
	
	private static void invokeMethod() {
		ArrayList<String> a = new ArrayList<String>();  
		Class c = a.getClass();  
		
		a.add("CSDN_SEU_Cavin");  
		try{  
		    Method method = c.getMethod("add",Object.class);  
		    method.invoke(a,100);  
		    System.out.println(a);  //[CSDN_SEU_Cavin, 100]  
		}catch(Exception e){  
		    e.printStackTrace();  
		}  
	} 
	
	
	
	private static void wildcard() {
		List<Integer> ex_int= new ArrayList<Integer>();    
	////�Ƿ���  List<Number> ex_num = ex_int; 
	}
}
