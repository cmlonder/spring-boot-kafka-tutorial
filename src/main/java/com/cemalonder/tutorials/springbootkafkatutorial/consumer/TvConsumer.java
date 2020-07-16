package com.cemalonder.tutorials.springbootkafkatutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TvConsumer {

  private final Logger logger = LoggerFactory.getLogger(TvConsumer.class);
  private Integer score = 0;

  @KafkaListener(topics = "scores", groupId = "tv")
  public void consume(String message) {
    logger.info("{}. This is outstanding to watch on TV. Score now {} - 0!", message, ++score);
  }

}