package me.shinsunyoung.springsecurity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class UserInfo {

  @Id
  @Column(name = "code")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long code;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "level")
  private int level;

  @Builder
  public UserInfo(String email, String password, int level) {
    this.email = email;
    this.password = password;
    this.level = level;
  }
}
