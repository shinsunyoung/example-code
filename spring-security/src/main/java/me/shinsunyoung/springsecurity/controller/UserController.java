package me.shinsunyoung.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shinsunyoung.springsecurity.dto.UserInfoDto;
import me.shinsunyoung.springsecurity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserService userService;

  @PostMapping("/user")
  public String signup(UserInfoDto infoDto) { // 회원 추가
    log.info(infoDto.toString());
    userService.save(infoDto);
    return "redirect:/login";
  }

}
