package me.shinsunyoung.springjwt.user.model.response;

import lombok.Getter;
import lombok.Setter;
import me.shinsunyoung.springjwt.user.domain.User;

@Setter
@Getter
public class AddUserResponse {

  private String email;
  private Long id;

  public AddUserResponse(User user) {
    this.email = user.getEmail();
    this.id = user.getId();
  }
}
