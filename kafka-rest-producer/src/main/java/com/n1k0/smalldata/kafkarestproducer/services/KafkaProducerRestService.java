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
public class KafkaProducerRestService {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaProducerRestService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/call")
    ResponseEntity<Void> sendCall(@RequestBody Call call){
        kafkaProducerService.produceCall(call);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/message")
    ResponseEntity<Void> sendMessage(@RequestBody Message message){
        kafkaProducerService.produceMessage(message);
        return ResponseEntity.ok().build();
    }


}
