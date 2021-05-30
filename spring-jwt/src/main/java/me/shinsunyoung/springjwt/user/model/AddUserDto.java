package me.shinsunyoung.springjwt.user.model;

import lombok.Getter;
import lombok.Setter;
import me.shinsunyoung.springjwt.user.domain.User;

@Setter
@Getter
public class AddUserDto {

  private String email;
  private String password;

  public User toEntity(String encodePassword) {
    return User.builder()
        .email(email)
        .password(encodePassword)
        .build();
  }
}
