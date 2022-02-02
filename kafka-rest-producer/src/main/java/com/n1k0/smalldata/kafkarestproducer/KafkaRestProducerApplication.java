package com.n1k0.smalldata.kafkarestproducer;

import com.n1k0.smalldata.kafkarestproducer.services.KafkaRestProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaRestProducerApplication {

    private final KafkaRestProducerService kafkaRestProducerService;

    @Autowired
    public KafkaRestProducerApplication(KafkaRestProducerService kafkaRestProducerService) {
        this.kafkaRestProducerService = kafkaRestProducerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaRestProducerApplication.class, args);
    }
}
