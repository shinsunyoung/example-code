package me.shinsunyoung.springevent.controller;

import me.shinsunyoung.springevent.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  RegisterService service;

  @GetMapping("/register/{name}")
  public void register(@PathVariable String name) {
    service.hello(name);
    System.out.println("회원가입을 완료했어요");
  }

}
