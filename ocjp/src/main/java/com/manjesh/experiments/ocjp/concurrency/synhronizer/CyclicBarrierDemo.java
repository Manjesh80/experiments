package com.manjesh.experiments.ocjp.concurrency.synhronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by aadhya on 12/12/2016.
 */

/*When you use the synchronized keyword, you employ mutexes to synchronize
between threads for safe shared access. Threads also often
needed to coordinate their executions to complete a bigger higher-level
task. It is possible to build higher-level abstractions for thread
synchronization. These high-level abstractions for synchronizing
activities of two or more threads are known as synchronizers.
Synchronizers internally make use of the existing low-level APIs
for thread coordination.*/

/*
CyclicBarrier helps provide a synchronization point where threads
may need to wait at a predefined execution point
until all other threads reach that point.
*/

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new GrandPrix());
        new Car(cyclicBarrier, "Ferrari");
        new Car(cyclicBarrier, "McLaren");
        new Car(cyclicBarrier, "Reb Bull");
        new Car(cyclicBarrier, "Audi");
    }
}

class GrandPrix extends Thread {
    @Override
    public void run() {
        System.out.println("All cars on track, let's race");
    }
}

class Car extends Thread {
    String name = "";
    CyclicBarrier waitBarrier;

    public Car(CyclicBarrier barrier, String name) {
        this.name = name;
        waitBarrier = barrier;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " is on track");

        try {
            waitBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

