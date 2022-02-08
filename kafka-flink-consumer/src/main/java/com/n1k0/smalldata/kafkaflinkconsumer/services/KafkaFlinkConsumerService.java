package com.n1k0.smalldata.kafkaflinkconsumer.services;

import com.n1k0.smalldata.kafkaflinkconsumer.config.KafkaFlinkConsumerConfig;
import org.apache.flink.runtime.taskexecutor.TaskExecutor;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Service;


@Service
public class KafkaFlinkConsumerService {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaFlinkConsumerService.class);

    private final KafkaFlinkConsumerConfig kafkaFlinkConsumerConfig;

    private final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    @Autowired
    public KafkaFlinkConsumerService(KafkaFlinkConsumerConfig kafkaFlinkConsumerConfig){
        this.kafkaFlinkConsumerConfig = kafkaFlinkConsumerConfig;
    }

    @Bean
    SimpleAsyncTaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public void readMessageFromKafka() throws Exception{
//        kafkaFlinkConsumerConfig.getStreamFromKafka(env).print();
        LOG.info("im alive");
        DataStream<String> test = env.fromElements("test1", "tist2", "tust3");
        test.print();
        env.execute();
    }

}
