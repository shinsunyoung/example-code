package me.shinsunyoung.springjwt.base.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springjwt.user.domain.User;
import me.shinsunyoung.springjwt.user.model.UserDto;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

  private final JwtProperties jwtProperties;

  public String makeJwtToken(User user) {
    Date now = new Date();

    return Jwts.builder()
        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
        .setIssuer(jwtProperties.getIssuer())
        .setIssuedAt(now)
        .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
        .claim("id", user.getId())
        .claim("email", user.getEmail())
        .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
        .compact();
  }

  public UserDto getUserDtoOf(String authorizationHeader) {
    validationAuthorizationHeader(authorizationHeader);

    String token = extractToken(authorizationHeader);
    Claims claims = parsingToken(token);

    return new UserDto(claims);
  }

  private Claims parsingToken(String token) {
    return Jwts.parser()
        .setSigningKey(jwtProperties.getSecretKey())
        .parseClaimsJws(token)
        .getBody();
  }

  private void validationAuthorizationHeader(String header) {
    if (header == null || !header.startsWith(jwtProperties.getTokenPrefix())) {
      throw new IllegalArgumentException();
    }
  }

  private String extractToken(String authorizationHeader) {
    return authorizationHeader.substring(jwtProperties.getTokenPrefix().length());
  }

}
