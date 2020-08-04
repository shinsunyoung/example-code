package me.shinsunyoung.corstest1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GreetingController {

  @GetMapping("/hello")
  public String hello() {
    return "안녕하세요?";
  }
}