package com.hlj.util.z025_synchronized._1_use;


public class Synchronized_2 {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			TwoMyThread thread = new TwoMyThread();
			thread.start();
		}
	}
}

class TeoSync {

	public  void test() {
		synchronized(this){
			System.out.println("test开始..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test结束..");
		}
	}
}

class TwoMyThread extends Thread {

	@Override
	public void run() {
		TeoSync sync = new TeoSync();
		sync.test();
	}
}
