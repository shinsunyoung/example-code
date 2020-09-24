package me.shinsunyoung.springvalidation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.springvalidation.annotation.Tel;

@NoArgsConstructor
@Getter
public class Obj {

  @NotBlank(message = "이름")
  private String name;

  @NotNull(message = "나이")
  private Integer age;

  @Tel
  private String tel;

  @Builder
  public Obj(@NotBlank(message = "이름") String name,
      @NotNull(message = "나이") Integer age) {
    this.name = name;
    this.age = age;
  }

  public Obj(@NotBlank(message = "이름") String name,
      @NotNull(message = "나이") Integer age, String tel) {
    this.name = name;
    this.age = age;
    this.tel = tel;
  }
}