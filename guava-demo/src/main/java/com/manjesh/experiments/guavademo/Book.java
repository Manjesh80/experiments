package com.manjesh.experiments.guavademo;

import com.google.common.collect.ComparisonChain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/14/2016.
 */
@Data
public class Book implements Comparator<Book>, Comparable<Book> {
    private Person author;
    private String title;
    private String publisher;
    private String isbn;
    private double price;

    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Book o) {
        return compareInternal(this, o);
    }

    public int compare(Book o1, Book o2) {
        return compareInternal(o1, o2);
    }

    private int compareInternal(Book o1, Book o2) {
        return ComparisonChain.start()
                .compare(o1.title, o2.title)
                .compare(o1.publisher, o2.publisher)
                .compare(o1.isbn, o2.isbn)
                .compare(o1.price, o2.price)
                .result();
    }
}
