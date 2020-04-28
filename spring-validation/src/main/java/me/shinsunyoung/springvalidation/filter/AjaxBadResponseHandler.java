package me.shinsunyoung.springvalidation.filter;

import me.shinsunyoung.springvalidation.dto.RestReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AjaxBadResponseHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<RestReponse> validException(
      MethodArgumentNotValidException ex) {

    RestReponse restReponse = new RestReponse(false,
        "유효성 검사 실패 : " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

    return ResponseEntity.badRequest()
        .body(restReponse);

  }
}
