package com.hlj.util.z031_泛型学习.origin;

/**
 * @author : HealerJean
 * @date   �� 2017��11��20�� ����3:44:40 
 * @Description: ���ܶ�ȷ�еķ�������ʹ��instanceof������������Ĳ����ǷǷ��ģ�����ʱ�����
 */
public class FourMain {
	
	public static void main(String[] args) {
	    FX<Number> ex_num = new FX<Number>(100);  
	    FX<Integer> ex_int = new FX<Integer>(200);  
	    
	/*	�������ܶ�ȷ�еķ�������ʹ��instanceof������������Ĳ����ǷǷ��ģ�����ʱ�������ȷ����Ӧ��ʹ�ã�
	 	if(ex_num instanceof FX<Number>){   
		} 
	 */
	    if(ex_num instanceof FX<?>){   
		} 
	}
	
	public static class FX<T> {  
	    private T ob;   
	    public FX(T ob) {  
	        this.ob = ob;  
	    }  
	}  
}
