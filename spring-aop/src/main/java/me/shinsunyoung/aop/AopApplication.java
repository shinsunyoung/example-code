package me.shinsunyoung.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // 추가
public class AopApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopApplication.class, args);
  }

}
