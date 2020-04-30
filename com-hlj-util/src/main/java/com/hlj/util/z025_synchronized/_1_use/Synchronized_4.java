package com.hlj.util.z025_synchronized._1_use;

public class Synchronized_4 {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			FourMyThread thread = new FourMyThread();
			thread.start();
		}
	}
}

class FourSync {

	public  void test() {
		synchronized(FourSync.class){
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

class FourMyThread extends Thread {

	@Override
	public void run() {
		FourSync sync = new FourSync();
		sync.test();
	}

}
