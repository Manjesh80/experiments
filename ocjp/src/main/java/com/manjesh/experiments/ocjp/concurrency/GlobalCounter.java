package com.manjesh.experiments.ocjp.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aadhya on 12/11/2016.
 */
public class GlobalCounter {
    public static long count = 0;
    public static AtomicInteger atomicCount = new AtomicInteger(0);
}
