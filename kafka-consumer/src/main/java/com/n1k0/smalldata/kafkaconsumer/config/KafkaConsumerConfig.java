package com.n1k0.smalldata.kafkaconsumer.config;

import com.n1k0.smalldata.kafkaconsumer.models.Call;
import com.n1k0.smalldata.kafkaconsumer.models.Sms;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrapAddress}")
    private String boostrapAddress;

    @Value("${kafka.groupId}")
    private String groupId;

    @Bean
    public Map<String, Object> consumerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return props;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, Call> callKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Long, Call> callFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        callFactory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerFactory(),
                new LongDeserializer(),
                new JsonDeserializer<>(Call.class)));

        return callFactory;
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, Sms> messageKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Long, Sms> messageFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        messageFactory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerFactory(),
                new LongDeserializer(),
                new JsonDeserializer<>(Sms.class)));

        return messageFactory;
    }


}
