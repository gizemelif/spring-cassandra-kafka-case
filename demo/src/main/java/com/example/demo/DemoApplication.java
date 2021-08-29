package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@KafkaListener(topics = "${gizem.kafka.topic}", groupId = "${gizem.kafka.group.id}")
	public void listener(String message) {
		logger.info("Received message = {}", message);
	}
}
