package com.manjesh.experiments.ocjp.concurrency;

/**
 * Created by aadhya on 12/11/2016.
 */
public class SimpleThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Name of SimpleThreadRunnable thread ==> " + Thread.currentThread().getName());
        System.out.println("ID of SimpleThreadRunnable thread ==> " + Thread.currentThread().getId());
        System.out.println("Priority of SimpleThreadRunnable thread ==> " + Thread.currentThread().getPriority());
        System.out.println("Details of SimpleThreadRunnable thread ==> " + Thread.currentThread().toString());

        for (int i = 0; i < 5; i++) {
            System.out.println("SimpleThreadRunnable ==> Running for ever");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
