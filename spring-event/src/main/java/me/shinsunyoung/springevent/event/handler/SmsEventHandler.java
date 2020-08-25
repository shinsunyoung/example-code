package me.shinsunyoung.springevent.event.handler;

import me.shinsunyoung.springevent.event.RegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmsEventHandler {

  @EventListener
  public void sendSms(RegisteredEvent event) {
    System.out.println(event.getName() + "님에게 가입 축하 메세지를 전송했습니다.");
  }

  @Async
  @EventListener
  public void makeCoupon(RegisteredEvent event) {
    System.out.println(event.getName() + "님에게 쿠폰을 전송했습니다.");
  }
}
