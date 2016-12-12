package com.manjesh.experiments.ocjp.concurrency;

/**
 * Created by aadhya on 12/11/2016.
 */
public class SimpleThreadExtension extends Thread {

    @Override
    public void run() {
        System.out.println("Name of SimpleThreadExtension thread ==> " + Thread.currentThread().getName());
        System.out.println("ID of SimpleThreadExtension thread ==> " + Thread.currentThread().getId());
        System.out.println("Priority of SimpleThreadExtension thread ==> " + Thread.currentThread().getPriority());
        System.out.println("Details of SimpleThreadExtension thread ==> " + Thread.currentThread().toString());

        for (int i = 0; i < 5; i++) {
            System.out.println("SimpleThreadExtension ==> Running for ever");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
