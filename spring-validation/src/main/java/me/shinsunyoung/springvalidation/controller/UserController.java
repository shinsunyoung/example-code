package me.shinsunyoung.springvalidation.controller;

import me.shinsunyoung.springvalidation.dto.User;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @GetMapping("/user")
  public String getAddPage(User user){
    return "add_user";
  }

  @PostMapping("/user")
  public String addUser(@Valid User user, BindingResult result){

    if(result.hasErrors()){
      return "add_user";
    }

    return "complete";
  }
}
