package me.shinsunyoung.springtest.controller;

import me.shinsunyoung.springtest.vo.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

  @GetMapping("/blog")
  public String blogGet(@RequestParam String name, @RequestParam String id){
    return name + "의 블로그입니다. " + id;
  }


  @PostMapping("/blog")
  public String blogPost(@RequestBody Info info){
    return info.getName() + "의 블로그입니다. " + info.getId();
  }

}
