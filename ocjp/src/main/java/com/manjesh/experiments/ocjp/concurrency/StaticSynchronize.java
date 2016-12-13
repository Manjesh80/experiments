package com.manjesh.experiments.ocjp.concurrency;

/**
 * Created by aadhya on 12/12/2016.
 */
public class StaticSynchronize {

    public static int val = 0;

    /*You cannot declare constructors synchronized; it will result in a
    compiler error. For example, for

    Why can’t you declare constructors synchronized? The JVM ensures that
     only one thread can invoke a constructor call (for a specific
     constructor) at a given point in time. So, there is no need to
     declare a constructor synchronized. However, if you want, you can
     use synchronized blocks inside constructors.

    public synchronized StaticSynchronize() { *//* constructor body *//*}*/


    public synchronized void assign(int i) {
        val = i;
    }

    public synchronized void assignLockInternal(int i) {
        synchronized (this) {
            val = i;
        }

        // Internally uses a lock on StaticSynchronize.class
        //Static synchronized methods acquire locks on the class object.
        // Every class is associated with an object of Class type, and you can access it
        // using ClassName.class syntax
        synchronized (StaticSynchronize.class) {
            val = i;
        }
    }
}
