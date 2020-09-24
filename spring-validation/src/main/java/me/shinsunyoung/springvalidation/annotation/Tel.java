package me.shinsunyoung.springvalidation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import me.shinsunyoung.springvalidation.annotation.validator.TelValidator;

@Target(ElementType.FIELD) // 필드에 적용
@Retention(RetentionPolicy.RUNTIME) // 실행할동안 어노테이션 유지
@Constraint(validatedBy = TelValidator.class)
public @interface Tel {
  String message() default "휴대폰 번호"; // 오류 메세지 default
  Class[] groups() default {};
  Class[] payload() default {};
}
