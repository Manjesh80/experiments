package com.manjesh.experiments.ocjp.concurrency;

/**
 * Created by aadhya on 12/11/2016.
 */
public class DemoConcurrency {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Name of main thread ==> " + Thread.currentThread().getName());
        System.out.println("ID of main thread ==> " + Thread.currentThread().getId());
        System.out.println("Priority of main thread ==> " + Thread.currentThread().getPriority());
        System.out.println("Details of main thread ==> " + Thread.currentThread().toString());

        SimpleThreadExtension simpleThreadExtension = new SimpleThreadExtension();
        simpleThreadExtension.start();
        simpleThreadExtension.join(2000);

        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("Name of Anonymous thread ==> " + Thread.currentThread().getName());
                System.out.println("ID of Anonymous thread ==> " + Thread.currentThread().getId());
                System.out.println("Priority of Anonymous thread ==> " + Thread.currentThread().getPriority());
                System.out.println("Details of Anonymous thread ==> " + Thread.currentThread().toString());

                for (int i = 0; i < 5; i++) {
                    System.out.println("Anonymous Thread ==> Running for ever");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        thread.start();

        SimpleThreadRunnable simpleThreadRunnable = new SimpleThreadRunnable();
        Thread useRunnable = new Thread(simpleThreadRunnable);
        useRunnable.start();
    }
}
