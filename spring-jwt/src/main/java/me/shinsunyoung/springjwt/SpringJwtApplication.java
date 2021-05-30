package me.shinsunyoung.springjwt;

import me.shinsunyoung.springjwt.base.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtProperties.class})
@SpringBootApplication
public class SpringJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJwtApplication.class, args);
  }

}
