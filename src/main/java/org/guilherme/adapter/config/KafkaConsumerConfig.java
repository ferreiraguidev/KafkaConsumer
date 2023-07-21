package org.guilherme.adapter.config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.guilherme.deserializer.CustomerDes;
import org.guilherme.model.Customer;

import java.util.Properties;

public class KafkaConsumerConfig {

    public static KafkaConsumer<String, Customer> properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "Identifier");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.guilherme.deserializer.CustomerDes");

        return new KafkaConsumer<>(properties);
    }

}
