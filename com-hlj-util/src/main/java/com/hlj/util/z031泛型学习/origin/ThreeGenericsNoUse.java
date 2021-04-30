package com.hlj.util.z031泛型学习.origin;
/** 
 * @author : HealerJean
 * @date
 * @Description:
 */
public class ThreeGenericsNoUse {

	public static void main(String[] args) {  
        FX intOb = new FX(new Integer(100));  
        intOb.showTyep();  
        System.out.println("value = " + intOb.getOb());
        System.out.println("----------------------------------");  
  
        FX strOb = new FX("CSDN_SEU_Calvin");  
        strOb.showTyep();  
        System.out.println("value = " + strOb.getOb());

    }

	public static class FX {  
	    private Object ob; //
	  
	    public FX(Object ob) {  
	        this.ob = ob;  
	    }  
	  
	    public Object getOb() {  
	        return ob;  
	    }  
	  
	    public void showTyep() {  
	        System.out.println("object =: " + ob.getClass().getName());
	    }  
	}  
	  
	
}
