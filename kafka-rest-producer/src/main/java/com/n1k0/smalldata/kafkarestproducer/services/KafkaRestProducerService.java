package com.n1k0.smalldata.kafkarestproducer.services;

import com.n1k0.smalldata.kafkarestproducer.models.Call;
import com.n1k0.smalldata.kafkarestproducer.models.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaRestProducerService {
    Logger LOG = LoggerFactory.getLogger(KafkaRestProducerService.class);

    @Value("${kafka.topics.calls}")
    private String topicCallsName;

    @Value("${kafka.topics.messages}")
    private String topicMessagesName;

    private final KafkaTemplate<Long, Call> kafkaCallTemplate;
    private final KafkaTemplate<Long, Sms> kafkaMessageTemplate;

    @Autowired
    public KafkaRestProducerService(KafkaTemplate<Long, Call> kafkaCallTemplate,
                                KafkaTemplate<Long, Sms> kafkaMessageTemplate){
        this.kafkaCallTemplate = kafkaCallTemplate;
        this.kafkaMessageTemplate = kafkaMessageTemplate;
    }

    public void produceCall(Call call){
        ListenableFuture <SendResult<Long, Call>> future = kafkaCallTemplate.send(topicCallsName, call);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, Call>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOG.debug("Unable to send call=[" + call + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Long, Call> result) {
                LOG.debug("Sent call=[" + call + "] with offset=[" +
                        result.getRecordMetadata().offset() + "]");
            }
        });
    }

    public void produceMessage(Sms sms){
        ListenableFuture<SendResult<Long, Sms>> future = kafkaMessageTemplate.send(topicMessagesName, sms);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, Sms>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOG.debug("Unable to send message=[" + sms + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Long, Sms> result) {
                LOG.debug("Sent message=[" + sms + "] with offset=[" +
                        result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
