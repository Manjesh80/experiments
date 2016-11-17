package com.manjesh.expermients.kafademo;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/16/2016.
 */
public class KafkaResponseHandler implements Callback {

    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if( recordMetadata != null) {
            System.out.println("Partition ==> " + recordMetadata.partition());
            System.out.println("Offset ==> " + recordMetadata.offset());
        }
        if( e != null) {
            e.printStackTrace();
        }
    }
}