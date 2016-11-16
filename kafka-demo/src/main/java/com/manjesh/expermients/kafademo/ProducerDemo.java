package com.manjesh.expermients.kafademo;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
            ProducerRecord<String, String> sampleRecord = new ProducerRecord<String, String>("jai-ganesh", "First Message from Java");
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
