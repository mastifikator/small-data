package com.n1k0.smalldata.kafkarestproducer.services;

import com.n1k0.smalldata.kafkarestproducer.models.Call;
import com.n1k0.smalldata.kafkarestproducer.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaProducerService {

    @Value("${kafka.topics.calls}")
    private String topicCallsName;

    @Value("${kafka.topics.messages}")
    private String topicMessagesName;

    private final KafkaTemplate<Long, Call> kafkaCallTemplate;
    private final KafkaTemplate<Long, Message> kafkaMessageTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<Long, Call> kafkaCallTemplate,
                                KafkaTemplate<Long, Message> kafkaMessageTemplate){
        this.kafkaCallTemplate = kafkaCallTemplate;
        this.kafkaMessageTemplate = kafkaMessageTemplate;
    }

    public void produceCall(Call call){
        ListenableFuture <SendResult<Long, Call>> future = kafkaCallTemplate.send(topicCallsName, call);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, Call>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send call=[" + call + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Long, Call> result) {
                System.out.println("Sent call=[" + call + "] with offset=[" +
                        result.getRecordMetadata().offset() + "]");
            }
        });
    }

    public void produceMessage(Message message){
        ListenableFuture<SendResult<Long, Message>> future = kafkaMessageTemplate.send(topicMessagesName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, Message>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Long, Message> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" +
                        result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
