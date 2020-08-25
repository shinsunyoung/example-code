package me.shinsunyoung.springevent.event;

public class RegisteredEvent {

  private String name;

  public RegisteredEvent(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
