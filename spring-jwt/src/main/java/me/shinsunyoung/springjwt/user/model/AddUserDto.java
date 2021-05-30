package me.shinsunyoung.springjwt.user.model;

import lombok.Builder;
import lombok.Getter;
import me.shinsunyoung.springjwt.user.domain.User;

@Getter
public class AddUserDto {

  private final String email;
  private final String password;

  @Builder
  public AddUserDto(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User toEntity(String encodePassword) {
    return User.builder()
        .email(email)
        .password(encodePassword)
        .build();
  }
}
