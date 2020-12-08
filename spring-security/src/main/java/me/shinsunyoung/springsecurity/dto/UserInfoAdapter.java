package me.shinsunyoung.springsecurity.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class UserInfoAdapter extends User {

  private final UserInfoDto userInfo;

  public UserInfoAdapter(UserInfoDto userInfo) {
    super(userInfo.getEmail(), userInfo.getPassword(), authorities(userInfo.getAuth()));
    this.userInfo = userInfo;
  }

  public static UserInfoAdapter from(UserInfoDto userInfoDto) {
    return new UserInfoAdapter(userInfoDto);
  }

  private static Collection<? extends GrantedAuthority> authorities(String auth) {
    Set<GrantedAuthority> roles = new HashSet<>();
    for (String role : auth.split(",")) {
      roles.add(new SimpleGrantedAuthority(role));
    }

    return roles;
  }
}
