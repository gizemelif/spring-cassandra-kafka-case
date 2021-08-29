package com.example.demo.controller;

import com.example.demo.dto.KMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class KafkaProducerController {
    @Value("${gizem.kafka.topic}")
    String topic;

    private KafkaTemplate<String, KMessage> kafkaTemplate;

    @PostMapping(path = "/messages")
    public void sendMessage(@RequestBody KMessage kMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kMessage);
    }
}
