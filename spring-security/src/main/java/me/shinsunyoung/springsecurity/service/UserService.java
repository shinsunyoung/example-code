package me.shinsunyoung.springsecurity.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springsecurity.domain.UserInfo;
import me.shinsunyoung.springsecurity.dto.UserInfoDto;
import me.shinsunyoung.springsecurity.repository.UserRepository;
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
        .auth(infoDto.getAuth())
        .password(infoDto.getPassword()).build()).getCode();
  }

  /**
   * Spring Security 필수 메소드 구현
   *
   * @param email 이메일
   * @return UserDetails
   * @throws UsernameNotFoundException
   */
  @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 User로 반환 타입 지정 (자동으로 다운 캐스팅됨)
  public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException((email)));
  }

  public List<UserInfo> findAll() {
    return userRepository.findAll();
  }

}
