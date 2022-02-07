package com.n1k0.smalldata.kafkaconsumer;

import com.n1k0.smalldata.kafkaconsumer.services.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {

    private KafkaConsumerService kafkaConsumerService;

    @Autowired
    public KafkaConsumerApplication(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }
}
