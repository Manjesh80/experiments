package com.manjesh.experiments.ocjp.concurrency;

/**
 * Created by aadhya on 12/11/2016.
 */
public class RaceConditionAtomic {

    public static void main(String[] args) {

        class IncrementAndPrint implements Runnable {
            @Override
            public void run() {
                System.out.println("Name of thread ==> " + Thread.currentThread().getName());
                System.out.println("ID of thread ==> " + Thread.currentThread().getId());

                for (int i = 0; i < 25; i++) {
                    //System.out.println(GlobalCounter.atomicCount.incrementAndGet());
                    GlobalCounter.count = GlobalCounter.count + 1;
                    System.out.println(GlobalCounter.count);
                }
            }
        }

        IncrementAndPrint incrementAndPrint = new IncrementAndPrint();
        Thread thread1 = new Thread(incrementAndPrint);
        Thread thread2 = new Thread(incrementAndPrint);
        Thread thread3 = new Thread(incrementAndPrint);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
