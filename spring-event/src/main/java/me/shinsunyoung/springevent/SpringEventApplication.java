package me.shinsunyoung.springevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringEventApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringEventApplication.class, args);
  }

}
