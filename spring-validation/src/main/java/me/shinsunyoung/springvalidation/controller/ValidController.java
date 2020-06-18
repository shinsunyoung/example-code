package me.shinsunyoung.springvalidation.controller;

import javax.validation.Valid;
import me.shinsunyoung.springvalidation.dto.Obj;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidController {
  @PostMapping("/valid")
  public Obj valid(@RequestBody @Valid Obj object){
    return object;
  }
}