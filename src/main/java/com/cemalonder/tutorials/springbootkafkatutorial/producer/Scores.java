package com.cemalonder.tutorials.springbootkafkatutorial.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Scores {

  private final Logger logger = LoggerFactory.getLogger(Scores.class);
  private static final String TOPIC = "scores";

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public Scores(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String name) {
    logger.info("Publishing message to {} topic", TOPIC);
    this.kafkaTemplate.send(TOPIC, name + " is scored a new goal!");
  }

}
