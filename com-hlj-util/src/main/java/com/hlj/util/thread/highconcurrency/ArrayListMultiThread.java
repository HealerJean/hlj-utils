package com.hlj.util.thread.highconcurrency;

import java.util.ArrayList;

/**
 * Created by 13 on 2017/5/4.
 */
public class ArrayListMultiThread {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>(10);

    public static class AddThread implements Runnable {

        /**
         * When an object implementing interface <retCode>Runnable</retCode> is used
         * to create a thread, starting the thread causes the object's
         * <retCode>run</retCode> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <retCode>run</retCode> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
        }
    }

    /**
     * ArrayList??????????????????,????????????????,???????????:
     * Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: 22
     * at java.Z007二维码.ArrayList.add(ArrayList.java:441)
     * at chapter2.ArrayListMultiThread$AddThread.run(ArrayListMultiThread.java:27)
     * at java.lang.Thread.run(Thread.java:745)
     *
     * Vector????????????????,???????ArrayList
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(arrayList.size());
    }

}
