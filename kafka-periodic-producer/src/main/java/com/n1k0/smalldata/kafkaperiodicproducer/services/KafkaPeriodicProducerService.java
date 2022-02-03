package com.n1k0.smalldata.kafkaperiodicproducer.services;

import com.n1k0.smalldata.kafkaperiodicproducer.generator.CallGenerator;
import com.n1k0.smalldata.kafkaperiodicproducer.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class KafkaPeriodicProducerService {

    @Value("${generator.telephoneRandomCount}")
    private int telephoneRandomCount;

    @Value("${generator.amountWordInMessage}")
    private int amountWordInMessage;

    @Value("#{'${generator.dictionary}'.split(' ')}")
    private List<String> dictionary;

    private final KafkaPeriodicService kafkaPeriodicService;

    @Autowired
    public KafkaPeriodicProducerService(KafkaPeriodicService kafkaPeriodicService) {
        this.kafkaPeriodicService = kafkaPeriodicService;
    }

    @Scheduled(fixedDelayString = "${generator.messagesDelay}")
    public void scheduleSendMessage(){
        kafkaPeriodicService.produceMessage(MessageGenerator.generate(telephoneRandomCount, amountWordInMessage, dictionary));
    }

    @Scheduled(fixedDelayString = "${generator.callsDelay}")
    public void scheduleSendCall(){
        kafkaPeriodicService.produceCall(CallGenerator.generate(telephoneRandomCount));
    }


}
