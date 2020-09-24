package me.shinsunyoung.springvalidation.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import me.shinsunyoung.springvalidation.annotation.Tel;

public class TelValidator implements ConstraintValidator<Tel, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    return value.matches("(01[016789])(\\d{3,4})(\\d{4})");
  }
}
