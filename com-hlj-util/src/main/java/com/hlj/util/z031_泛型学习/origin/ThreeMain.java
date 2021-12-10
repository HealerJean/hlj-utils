package com.hlj.util.z031_泛型学习.origin;
/** 
 * @author : HealerJean
 * @date   �� 2017��11��20�� ����1:36:12 
 * @Description: Number��Ϊ����������ͨ��  
 */
public class ThreeMain {
	public static void main(String[] args) {  
	    FX<Number> ex_num = new FX<Number>(100);  
	    FX<Integer> ex_int = new FX<Integer>(200);  
	    getData(ex_num);  
	//    getData(ex_int);//�������  
	    
	    getUpperNumberData(ex_num);
	    getUpperNumberData(ex_int);

	}  
	  
	public static void getData(FX<Number> temp) { //��������Number��Ϊ������ ����T ����ͨ��  
	    //do something...  
	}  
	
	public static void getUpperNumberData(FX<? extends Number> temp){  
	      System.out.println("class type :" + temp.getClass());  
	}       
	public static class FX<T> {  
	    private T ob;   
	    public FX(T ob) {  
	        this.ob = ob;  
	    }  
	}  
}
