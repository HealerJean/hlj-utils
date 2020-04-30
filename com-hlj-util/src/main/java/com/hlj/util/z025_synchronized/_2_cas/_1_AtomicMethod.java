package com.hlj.util.z025_synchronized._2_cas;

import java.util.concurrent.atomic.AtomicLong;

public class _1_AtomicMethod {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                if (Counter.addOne() == 1000) {
                    System.out.println("counter = 1000");
                }
            });
            thread.start();
        }
    }

}

/* class Counter {
    private static long counter = 0;

    public static  long addOne(){
        return ++counter;
    }
}*/

class Counter {
    private static AtomicLong atomicLong = new AtomicLong(0);

    public static long addOne() {
        return atomicLong.incrementAndGet();
    }
}
