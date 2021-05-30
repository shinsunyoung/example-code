package me.shinsunyoung.springjwt.base.config;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springjwt.base.jwt.JwtAuthenticationFilter;
import me.shinsunyoung.springjwt.base.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String[] PUBLIC_URLS = {
      "/sign-up", "/sign-in"
  };

  private final JwtTokenProvider jwtTokenProvider;

  @Bean
  public PasswordEncoder passwordEncoderParser() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .httpBasic().disable()
        .formLogin().disable()
        .logout().disable();

    http.authorizeRequests()
        .mvcMatchers(PUBLIC_URLS).permitAll()
        .anyRequest().authenticated();

    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(
        JwtAuthenticationFilter.of(jwtTokenProvider),
        UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring()
        .mvcMatchers(PUBLIC_URLS);
  }
}
