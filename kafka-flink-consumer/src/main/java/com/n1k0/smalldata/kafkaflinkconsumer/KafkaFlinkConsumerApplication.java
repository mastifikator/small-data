package com.n1k0.smalldata.kafkaflinkconsumer;

import com.n1k0.smalldata.kafkaflinkconsumer.services.KafkaFlinkConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaFlinkConsumerApplication {

    private KafkaFlinkConsumerService kafkaFlinkConsumerService;

    @Autowired
    public KafkaFlinkConsumerApplication(KafkaFlinkConsumerService kafkaFlinkConsumerService) {
        this.kafkaFlinkConsumerService = kafkaFlinkConsumerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaFlinkConsumerApplication.class, args);
    }
}

