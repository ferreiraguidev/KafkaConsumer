package org.guilherme;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

import static org.guilherme.adapter.config.KafkaConsumerConfig.properties;

public class Main {
    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(properties());
        var topic = "typeOfMessageTransitsHere";

        consumer.subscribe(Collections.singletonList(topic));


        while(true){
            // pull records -> set time out
            var records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String,String> record : records){
                System.out.println("event recieved");
                System.out.println("----------------");
                System.out.println("KEY: " + record.key());
                System.out.println("VALUE: " + record.value());
                System.out.println("----------------");
            }
        }
    }
}
