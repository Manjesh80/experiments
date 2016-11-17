package com.manjesh.expermients.kafademo;

import com.google.gson.Gson;
import com.manjesh.experiments.common.Book;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/16/2016.
 */
public class BookSerializer implements Serializer<Book>{

    public void configure(Map<String, ?> map, boolean b) {

    }

    public byte[] serialize(String s, Book book) {
        byte[] serializedBook = new byte[0];
        try {
            System.out.println("Invoking book Serializer");
            serializedBook = (new Gson()).toJson(book).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return serializedBook;
    }

    public void close() {

    }
}
