package me.shinsunyoung.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.shinsunyoung.springsecurity.domain.UserInfo;

@ToString
@Getter
@Setter
public class UserInfoDto {

  private Long code;

  private String email;
  private String password;

  private int level;

  public UserInfoDto() {
  }

  public UserInfoDto(UserInfo userInfo) {
    this.code = userInfo.getCode();
    this.email = userInfo.getEmail();
    this.password = userInfo.getPassword();
    this.level = userInfo.getLevel();
  }

}
