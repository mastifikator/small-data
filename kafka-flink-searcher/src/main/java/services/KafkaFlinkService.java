package services;

import config.KafkaFlinkConfig;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class KafkaFlinkService {

    private final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    private static final String SEARCH_WORD = "putin";

    public void startReadWriteKafka() throws Exception{
        DataStream<String> inputStream = KafkaFlinkConfig.createStream(env);
        KafkaSink<String> sink = KafkaFlinkConfig.createSink();

        SingleOutputStreamOperator<String> outputStream = inputStream.filter(s -> s.contains(SEARCH_WORD));
        outputStream.print();
        outputStream.sinkTo(sink);

        env.execute();
    }



}
