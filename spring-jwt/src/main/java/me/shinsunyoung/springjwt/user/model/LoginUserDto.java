package me.shinsunyoung.springjwt.user.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserDto {

  private String email;
  private String password;

  public LoginUserDto(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
