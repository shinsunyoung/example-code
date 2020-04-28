package me.shinsunyoung.springvalidation.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

  @NotBlank(message = "이메일을 입력해주세요.")
  @Email(message = "이메일 형식을 맞춰주세요.")
  private String email;

  @NotBlank(message = "이름을 입력해주세요.")
  @Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
  private String name;

  @Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자로 포함해서 6~12자리 이내로 입력해주세요.")
  private String password;

}
