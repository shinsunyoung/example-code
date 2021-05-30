package me.shinsunyoung.springjwt.user.model;

import lombok.Getter;

@Getter
public class LoginUserDto {

  private final String email;
  private final String password;

  public LoginUserDto(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
