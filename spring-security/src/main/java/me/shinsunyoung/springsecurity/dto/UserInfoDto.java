package me.shinsunyoung.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
  private Long code;

  private String email;
  private String password;

  private String auth;

  public UserInfoDto() {
  }
}
