package com.hlj.util.z025_synchronized;


public class Synchronized_3to1 {

    public static void main(String[] args) {
        ThreeOneSync threeTeoSync = new ThreeOneSync();

        for (int i = 0; i < 3; i++) {
            ThreeOneMyThread thread = new ThreeOneMyThread(threeTeoSync);
            thread.start();
        }
    }
}

class ThreeOneSync {

    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");

    }
}

class ThreeOneMyThread extends Thread {

    public ThreeOneSync threeTeoSync;

    public ThreeOneMyThread(ThreeOneSync threeTeoSync){
        this.threeTeoSync = threeTeoSync;
    }
    public void run() {
        threeTeoSync.test();
    }
}
