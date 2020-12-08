package me.shinsunyoung.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springsecurity.dto.LoginUser;
import me.shinsunyoung.springsecurity.dto.UserInfoDto;
import me.shinsunyoung.springsecurity.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserService userService;

  @PostMapping("/user")
  public String signUp(UserInfoDto infoDto) { // 회원 추가
    userService.save(infoDto);
    return "redirect:/login";
  }

  @GetMapping(value = "/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    return "redirect:/login";
  }

  @ResponseBody
  @GetMapping("/user/info")
  public UserInfoDto loginInfoWithAnnotation(@LoginUser UserInfoDto userInfo) {
    return userInfo;
  }
}
