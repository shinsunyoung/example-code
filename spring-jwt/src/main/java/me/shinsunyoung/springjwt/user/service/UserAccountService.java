package me.shinsunyoung.springjwt.user.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springjwt.base.jwt.JwtTokenProvider;
import me.shinsunyoung.springjwt.user.domain.User;
import me.shinsunyoung.springjwt.user.model.AddUserDto;
import me.shinsunyoung.springjwt.user.model.LoginUserDto;
import me.shinsunyoung.springjwt.user.model.response.AddUserResponse;
import me.shinsunyoung.springjwt.user.model.response.LoginUserResponse;
import me.shinsunyoung.springjwt.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountService {

  private final UserRepository userRepository;
  private final JwtTokenProvider jwtTokenProvider;
  private final PasswordEncoder passwordEncoder;

  public AddUserResponse signUp(AddUserDto user) {
    String encodingPassword = encodingPassword(user.getPassword());
    User savedUser = userRepository.save(user.toEntity(encodingPassword));

    return new AddUserResponse(savedUser);
  }

  public LoginUserResponse signIn(LoginUserDto userDto) {
    User user = userRepository.findByEmail(userDto.getEmail())
        .orElseThrow(IllegalArgumentException::new);

    passwordMustBeSame(userDto.getPassword(), user.getPassword());

    String token = jwtTokenProvider.makeJwtToken(user);
    return new LoginUserResponse(token);
  }

  private void passwordMustBeSame(String requestPassword, String password) {
    if (!passwordEncoder.matches(requestPassword, password)) {
      throw new IllegalArgumentException();
    }
  }

  private String encodingPassword(String password) {
    return passwordEncoder.encode(password);
  }
}
