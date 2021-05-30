package me.shinsunyoung.springjwt.user.model.response;

import lombok.Getter;

@Getter
public class LoginUserResponse {

  private final String accessToken;

  public LoginUserResponse(String accessToken) {
    this.accessToken = accessToken;
  }
}
