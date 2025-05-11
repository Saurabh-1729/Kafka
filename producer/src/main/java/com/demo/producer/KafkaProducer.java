package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {
//    Similar as RestTemplate
    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        RiderLocation riderLocation = new RiderLocation("123", 12.9716, 77.5946);
//       what ever message I want to send to the topic "my-topic"
        kafkaTemplate.send("my-new-topic", riderLocation);
        return "Message sent" + riderLocation.getRiderId();
    }
}
