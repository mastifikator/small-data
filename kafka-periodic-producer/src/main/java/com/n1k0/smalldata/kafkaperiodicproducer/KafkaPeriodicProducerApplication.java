package com.n1k0.smalldata.kafkaperiodicproducer;

import com.n1k0.smalldata.kafkaperiodicproducer.services.KafkaPeriodicProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaPeriodicProducerApplication {
    private final KafkaPeriodicProducerService kafkaPeriodicProducerService;

    @Autowired
    public KafkaPeriodicProducerApplication(KafkaPeriodicProducerService kafkaProducerRestService) {
        this.kafkaPeriodicProducerService = kafkaProducerRestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaPeriodicProducerApplication.class, args);
    }
}
