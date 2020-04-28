package me.shinsunyoung.springvalidation.dto;

import lombok.Getter;

@Getter
public class RestReponse {

  private boolean success;
  private String message;
  private Object data;

  public RestReponse(boolean success, String message) {
    this.success = success;
    this.message = message;
  }
}