package com.n1k0.smalldata.kafkarestproducer;

import com.n1k0.smalldata.kafkarestproducer.services.KafkaProducerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

    private final KafkaProducerRestService kafkaProducerRestService;

    @Autowired
    public KafkaProducerApplication(KafkaProducerRestService kafkaProducerRestService) {
        this.kafkaProducerRestService = kafkaProducerRestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
