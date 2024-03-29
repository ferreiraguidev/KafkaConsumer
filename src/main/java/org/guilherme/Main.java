package org.guilherme;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.guilherme.adapter.config.KafkaConsumerConfig;
import org.guilherme.model.Customer;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        var topic = "typeOfMessageTransitsHere";

        Customer msgProd = new Customer("10125556289", "G.uilherme");

        AtomicReference<Customer> msgCons = new AtomicReference<>();
        KafkaConsumer<String, Customer> consumer = KafkaConsumerConfig.properties();
        consumer.subscribe(Arrays.asList(topic));

        ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofSeconds(999));
        records.forEach(record -> {
            msgCons.set(record.value());
            System.out.println("Message received " + msgProd.getCpf() + "   " + msgProd.getName());
        });
        consumer.close();

    }
}
