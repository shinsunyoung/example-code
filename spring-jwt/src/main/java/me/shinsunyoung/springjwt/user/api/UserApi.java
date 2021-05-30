package me.shinsunyoung.springjwt.user.api;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springjwt.user.model.AddUserDto;
import me.shinsunyoung.springjwt.user.model.LoginUserDto;
import me.shinsunyoung.springjwt.user.model.response.AddUserResponse;
import me.shinsunyoung.springjwt.user.model.response.LoginUserResponse;
import me.shinsunyoung.springjwt.user.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserApi {

  private final UserAccountService userAccountService;

  @PostMapping("/users/sign-up")
  public ResponseEntity<AddUserResponse> signUp(@RequestBody AddUserDto addUserDto) {
    AddUserResponse savedUser = userAccountService.signUp(addUserDto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedUser);
  }

  @PostMapping("/users/sign-in")
  public ResponseEntity<LoginUserResponse> signIn(
      @RequestBody LoginUserDto loginUserDto) {
    LoginUserResponse loginUserResponse = userAccountService.signIn(loginUserDto);

    return ResponseEntity.ok()
        .body(loginUserResponse);
  }

}
