package com.manjesh.experiments.ocjp.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aadhya on 12/12/2016.
 */
class Counter {
    public static Integer integer = new Integer(0);
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
}

class AtomicVariableTest {
    static class Incrementer extends Thread {
        public void run() {
            Counter.integer++;
            Counter.atomicInteger.incrementAndGet();
        }
    }
    static class Decrementer extends Thread {
        public void run() {
            Counter.integer--;
            Counter.atomicInteger.decrementAndGet();
        }
    }
    public static void main(String []args) throws InterruptedException {
        Thread incremeterThread[] = new Incrementer[1000];
        Thread decrementerThread[] = new Decrementer[1000];

        for(int i = 0; i < 1000; i++) {
            incremeterThread[i] = new Incrementer();
            decrementerThread[i] = new Decrementer();
            incremeterThread[i].start();
            decrementerThread[i].start();
        }
        for(int i = 0; i < 1000; i++) {
            incremeterThread[i].join();
            decrementerThread[i].join();
        }
        System.out.printf("Integer value = %d AtomicInteger value = %d ",
                Counter.integer, Counter.atomicInteger.get());
    }
}