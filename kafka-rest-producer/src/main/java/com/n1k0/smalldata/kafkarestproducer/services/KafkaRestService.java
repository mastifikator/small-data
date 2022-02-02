package com.n1k0.smalldata.kafkarestproducer.services;

import com.n1k0.smalldata.kafkarestproducer.models.Call;
import com.n1k0.smalldata.kafkarestproducer.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaRestService {

    private final KafkaRestProducerService kafkaRestProducerService;

    @Autowired
    public KafkaRestService(KafkaRestProducerService kafkaRestProducerService) {
        this.kafkaRestProducerService = kafkaRestProducerService;
    }

    @PostMapping("/call")
    ResponseEntity<Void> sendCall(@RequestBody Call call){
        kafkaRestProducerService.produceCall(call);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/message")
    ResponseEntity<Void> sendMessage(@RequestBody Message message){
        kafkaRestProducerService.produceMessage(message);
        return ResponseEntity.ok().build();
    }


}
