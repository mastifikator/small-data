package config;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class KafkaFlinkConfig {

    private static final String boostrapAddress = "172.16.215.62:9092";
    private static final String groupId = "flink-consumer";
    private static final String topicCallsName = "calls";
    private static final String topicMessagesName = "messages";
    private static final String topicFilteredCallsName = "callsFiltered";
    private static final String topicFilteredMessagesName = "messagesFiltered";

    public static DataStream<String> createStream(StreamExecutionEnvironment env) {

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers(boostrapAddress)
                .setTopics(topicCallsName, topicMessagesName)
                .setGroupId(groupId)
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        return env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");
    }

    public static KafkaSink<String> createSink(){
        return KafkaSink.<String>builder()
                .setBootstrapServers(boostrapAddress)
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic(topicFilteredMessagesName)
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .build())
                .build();
    }

}

