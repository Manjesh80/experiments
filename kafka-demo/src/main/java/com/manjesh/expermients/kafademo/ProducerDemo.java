package com.manjesh.expermients.kafademo;

import com.google.gson.Gson;
import com.manjesh.experiments.common.Review;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.manjesh.experiments.common.Book;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/16/2016.
 */
public class ProducerDemo {

    public ProducerDemo() {

    }

    public static void sendKafkaMessages() {
        Properties kafkaProps = new Properties();

        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(kafkaProps);

        for (int i = 0; i < 5; i++) {
            Book book = new Book("Ganesh author", "Book Number - " + Integer.toString(i), "Kailash Publisher", "Test-ISBN", 1.0);
            book.setReviewers(Arrays.asList(new Review("Review by Ganesh")));
            ProducerRecord<String, String> sampleRecord = new ProducerRecord<String, String>(
                    "jai-ganesh", (new Gson()).toJson(book));
            KafkaResponseHandler responseHandler = new KafkaResponseHandler();
            kafkaProducer.send(sampleRecord, responseHandler);
            /*try {
                Future<RecordMetadata> future = kafkaProducer.send(sampleRecord);
                RecordMetadata response;
                response = future.get();
                System.out.println("Partition ==> " + response.partition());
                System.out.println("Offset ==> " + response.partition());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) {


        Thread producerThread = new Thread() {
            @Override
            public void run() {
                ProducerDemo.sendKafkaMessages();
            }
        };
        producerThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
