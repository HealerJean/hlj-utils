package com.hlj.util.z025_synchronized._1_use;

public class Synchronized_3to2 {

	public static void main(String[] args) {
		ThreeTeoSync threeTeoSync = new ThreeTeoSync();

		for (int i = 0; i < 3; i++) {
			ThreeTwoMyThread thread = new ThreeTwoMyThread(threeTeoSync);
			thread.start();
		}
	}
}

class ThreeTeoSync {

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

class ThreeTwoMyThread extends Thread {

	public ThreeTeoSync threeTeoSync;

	public ThreeTwoMyThread(ThreeTeoSync threeTeoSync){
		this.threeTeoSync = threeTeoSync;
	}
	public void run() {
		threeTeoSync.test();
	}
}
