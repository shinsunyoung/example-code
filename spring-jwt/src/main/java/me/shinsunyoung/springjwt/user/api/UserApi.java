package me.shinsunyoung.springjwt.user.api;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springjwt.user.model.AddUserDto;
import me.shinsunyoung.springjwt.user.model.LoginUserDto;
import me.shinsunyoung.springjwt.user.model.UserDto;
import me.shinsunyoung.springjwt.user.model.response.AddUserResponse;
import me.shinsunyoung.springjwt.user.model.response.LoginUserResponse;
import me.shinsunyoung.springjwt.user.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserApi {

  private final UserAccountService userAccountService;

  @PostMapping("/sign-up")
  public ResponseEntity<AddUserResponse> signUp(@RequestBody AddUserDto addUserDto) {
    AddUserResponse savedUser = userAccountService.signUp(addUserDto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedUser);
  }

  @PostMapping("/sign-in")
  public ResponseEntity<LoginUserResponse> signIn(
      @RequestBody LoginUserDto loginUserDto) {
    LoginUserResponse loginUserResponse = userAccountService.signIn(loginUserDto);

    return ResponseEntity.ok()
        .body(loginUserResponse);
  }


  @GetMapping("/hello")
  public String hello(@AuthenticationPrincipal UserDto user) {
    return user.getEmail() + ", 안녕하세요!";
  }

}
