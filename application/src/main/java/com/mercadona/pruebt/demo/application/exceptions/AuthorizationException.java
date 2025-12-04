package com.mercadona.pruebt.demo.application.exceptions;

public class AuthorizationException extends PruebatException{

  public AuthorizationException(ErrorCode code, Object... parameters) {
    super(code, parameters);
  }

}
