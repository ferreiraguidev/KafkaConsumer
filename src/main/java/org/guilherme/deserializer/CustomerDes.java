package org.guilherme.deserializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.guilherme.model.Customer;

import java.util.Map;


@Slf4j
public class CustomerDes implements Deserializer<Customer> {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Customer customer = new Customer("5454545", "name");

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Customer deserialize(String topic, byte[] customer) {
        try {
            if (customer == null) {
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");

            return objectMapper.readValue(new String(customer, "UTF-8"), Customer.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
    }


}
