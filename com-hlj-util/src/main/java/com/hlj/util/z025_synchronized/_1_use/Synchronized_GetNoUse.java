package com.hlj.util.z025_synchronized._1_use;

public class Synchronized_GetNoUse {

	public static int incr = 0 ;

	public static synchronized void  increment()  {
		incr++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Synchronized_GetNoUse.increment();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(()-> System.out.println("incr的值为"+incr )).start();
	}
}

