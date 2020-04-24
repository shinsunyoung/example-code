package me.shinsunyoung.aop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @PostMapping("/test")
  public String test(@RequestBody String request){

    System.out.println(request);

    return request;
  }

}
