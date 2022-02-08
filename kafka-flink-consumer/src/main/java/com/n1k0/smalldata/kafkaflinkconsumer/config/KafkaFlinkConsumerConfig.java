package com.n1k0.smalldata.kafkaflinkconsumer.config;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaFlinkConsumerConfig {

    @Value("${kafka.bootstrapAddress}")
    private String boostrapAddress;

    @Value("${kafka.groupId}")
    private String groupId;

    @Value("${kafka.topics.calls}")
    private String topicCallsName;

    @Value("${kafka.topics.messages}")
    private String topicMessagesName;

    public DataStream<String> getStreamFromKafka(StreamExecutionEnvironment env) {

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers(boostrapAddress)
                .setTopics(topicCallsName, topicMessagesName)
                .setGroupId(groupId)
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        return env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");
    }

}

