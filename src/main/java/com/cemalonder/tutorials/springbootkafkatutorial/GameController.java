package com.cemalonder.tutorials.springbootkafkatutorial;

import com.cemalonder.tutorials.springbootkafkatutorial.producer.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  private final Scores scores;

  @Autowired
  public GameController(Scores scores) {
    this.scores = scores;
  }

  @PostMapping(value = "/score")
  public void makeAnnouncement(@RequestParam("name") String name) {
    this.scores.sendMessage(name);
  }

}
