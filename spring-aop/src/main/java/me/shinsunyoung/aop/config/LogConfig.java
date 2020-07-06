package me.shinsunyoung.aop.config;

import com.google.common.base.Joiner;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@Aspect
public class LogConfig {

  @Around("within(me.shinsunyoung.aop.controller..*) && !@annotation(me.shinsunyoung.aop.config.LogExclusion)") //
  public Object logging(ProceedingJoinPoint pjp) throws Throwable { // 2

    String params = getRequestParams(); // request 값 가져오기

    long startAt = System.currentTimeMillis();

    log.info("-----------> REQUEST : {}({}) = {}", pjp.getSignature().getDeclaringTypeName(),
        pjp.getSignature().getName(), params);

    Object result = pjp.proceed(); // 4

    long endAt = System.currentTimeMillis();

    log.info("-----------> RESPONSE : {}({}) = {} ({}ms)", pjp.getSignature().getDeclaringTypeName(),
        pjp.getSignature().getName(), result, endAt - startAt);

    return result;
  }


  private String paramMapToString(Map<String, String[]> paramMap) {
    return paramMap.entrySet().stream()
        .map(entry -> String.format("%s -> (%s)",
            entry.getKey(), Joiner.on(",").join(entry.getValue())))
        .collect(Collectors.joining(", "));
  }

  // Get request values
  private String getRequestParams() {

    String params = "없음";

    RequestAttributes requestAttributes = RequestContextHolder
        .getRequestAttributes(); // 3

    if (requestAttributes != null) {
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
          .getRequestAttributes()).getRequest();

      Map<String, String[]> paramMap = request.getParameterMap();
      if (!paramMap.isEmpty()) {
        params = " [" + paramMapToString(paramMap) + "]";
      }
    }

    return params;
  }
}