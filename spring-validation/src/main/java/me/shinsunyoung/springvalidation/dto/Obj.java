package me.shinsunyoung.springvalidation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Obj {

  @NotBlank(message = "이름")
  private String name;

  @NotNull(message = "나이")
  private Integer age;

}