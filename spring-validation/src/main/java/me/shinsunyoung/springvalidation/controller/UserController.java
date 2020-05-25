package me.shinsunyoung.springvalidation.controller;

import me.shinsunyoung.springvalidation.dto.Obj;
import me.shinsunyoung.springvalidation.dto.User;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @ResponseBody
  @GetMapping("/object_test")
  public Obj letsGo() {

    return Obj.builder()
        .name("선영")
        .build();
  }

}
