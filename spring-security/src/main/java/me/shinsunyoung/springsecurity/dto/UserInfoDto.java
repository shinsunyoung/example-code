package me.shinsunyoung.springsecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.shinsunyoung.springsecurity.domain.UserInfo;

@NoArgsConstructor
@Getter
@Setter
public class UserInfoDto {
  private String email;
  private String password;
  private String auth;

  public UserInfoDto(UserInfo userInfo) {
    this.email = userInfo.getEmail();
    this.password = userInfo.getPassword();
    this.auth = userInfo.getAuth();
  }
}
