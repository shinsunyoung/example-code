package me.shinsunyoung.aop.controller;

import me.shinsunyoung.aop.config.LogExclusion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @PostMapping("/test")
  public String test(@RequestBody String request){
    return request;
  }

  @GetMapping("/test1")
  public void test1(){
    System.out.println("TEST1");
  }

  @LogExclusion // 로깅 제외
  @GetMapping("/test2")
  public void test2(){
    System.out.println("TEST2");
  }

}
