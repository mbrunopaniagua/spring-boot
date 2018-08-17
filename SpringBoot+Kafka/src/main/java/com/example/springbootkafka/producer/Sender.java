package com.example.springbootkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
	private static final Logger log = LoggerFactory.getLogger(Sender.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public Sender(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(String topic, String payload) {
		log.info("sending payload={} to topic={}", payload, topic);
		kafkaTemplate.send(topic, payload);
	}
}
