package com.manjesh.experiments.ocjp.concurrency.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/20/2016.
 */
public class DemoExecutor {

    public static void main(String[] args) {

    }

class SimpleRunnableTask implements Runnable {
    public void run() {
        System.out.println(" Simple runnable task ");
    }
}
}
