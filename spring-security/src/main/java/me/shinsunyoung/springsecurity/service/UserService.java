package me.shinsunyoung.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springsecurity.domain.Role;
import me.shinsunyoung.springsecurity.domain.UserInfo;
import me.shinsunyoung.springsecurity.dto.UserInfoDto;
import me.shinsunyoung.springsecurity.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  /**
   * 회원정보 저장
   *
   * @param infoDto 회원정보가 들어있는 DTO
   * @return 저장되는 회원의 PK
   */
  @Transactional
  public Long save(UserInfoDto infoDto) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    infoDto.setPassword(encoder.encode(infoDto.getPassword()));

    return userRepository.save(UserInfo.builder()
        .email(infoDto.getEmail())
        .level(infoDto.getLevel())
        .password(infoDto.getPassword()).build()).getCode();
  }

  /**
   * Spring Security 필수 메소드 구현
   *
   * @param email 이메일
   * @return UserDetails
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현

    UserInfo userInfo = userRepository.findByEmail(email).get();
    List<GrantedAuthority> authorities = new ArrayList<>(); // 권한 설정

    if (userInfo.getLevel() == 1) { // 권한에 따라 설정
      authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
    } else {
      authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
    }

    return new User(userInfo.getEmail(), userInfo.getPassword(), authorities); // username, password, 권한 순서대로 생성
  }
}
