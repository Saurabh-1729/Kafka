package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}


//only one consumer can consume the message from same group ID
//if we want to consume the message from same topic by multiple consumer then we have to give different group id
