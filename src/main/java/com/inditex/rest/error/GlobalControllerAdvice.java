package com.inditex.rest.error;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

  private static final Logger LOG = Logger.getLogger(GlobalControllerAdvice.class);

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    LOG.error(ex);
    return ResponseEntity
        .status(status)
        .headers(headers)
        .body(ApiError
            .builder()
            .status(status)
            .date(LocalDateTime.now())
        .message(ex.getMessage())
        .build());
  }
}
