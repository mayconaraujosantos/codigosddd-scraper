package com.madsant.codigosddd.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class StatesAreaCodeException extends RuntimeException {

  public StatesAreaCodeException(String message) {
    super(message);
  }

  public StatesAreaCodeException(String message, Throwable cause) {
    super(message, cause);
  }
}
