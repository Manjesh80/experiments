package com.manjesh.experiments.memorydemo;


import com.manjesh.experiments.common.Book;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aadhya on 11/27/2016.
 */
public class MemoryDemo {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) {
        System.out.println("Starting - Ganesh");
        List<Book> millionBooks = new LinkedList<>();
        int million = 1000000;
        Runtime runtime = Runtime.getRuntime();
        for (int i = 1; i < million; i++) {
            String bookNumber = Integer.toString(i);
            millionBooks.add(
                    new Book("Ganesh" + bookNumber," Ganesh author"+bookNumber, "Ganesh publisher"+bookNumber,"book isbn"+ bookNumber, i)
            );
            if( i % 100000 == 0) {
                long memory = runtime.totalMemory() - runtime.freeMemory();

                System.out.println(LocalDateTime.now().toString());
                System.out.println("Used memory is bytes: " + memory);
                System.out.println("Used memory is bytes: " + memory);
                System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
                System.out.println("\r\n\r\n");
            }
        }
    }
}
