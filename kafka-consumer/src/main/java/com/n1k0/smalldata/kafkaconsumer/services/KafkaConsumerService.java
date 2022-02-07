package com.n1k0.smalldata.kafkaconsumer.services;

import com.n1k0.smalldata.kafkaconsumer.models.Call;
import com.n1k0.smalldata.kafkaconsumer.models.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaConsumerService {

    Logger LOG = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(id="calls",
            groupId ="${kafka.groupId}",
            topics="${kafka.topics.calls}",
            containerFactory = "callKafkaListenerContainerFactory")
    public void consume(@Payload Call call){

        LOG.info("received Call = '{}'", call);
    }

    @KafkaListener(id="messages",
            groupId ="${kafka.groupId}",
            topics="${kafka.topics.messages}",
            containerFactory = "messageKafkaListenerContainerFactory")
    public void consume(@Payload Sms sms){

        LOG.info("received Sms = '{}'", sms);
    }
}
