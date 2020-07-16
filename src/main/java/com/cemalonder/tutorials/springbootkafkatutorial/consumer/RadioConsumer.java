package com.cemalonder.tutorials.springbootkafkatutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RadioConsumer {

  private final Logger logger = LoggerFactory.getLogger(RadioConsumer.class);
  private Integer score = 0;

  @KafkaListener(topics = "scores", groupId = "radio")
  public void consume(String message) {
    logger.info("{}. Score is now {}-0 for the people who just turned on their Radios!", message,
        ++score);
  }

}