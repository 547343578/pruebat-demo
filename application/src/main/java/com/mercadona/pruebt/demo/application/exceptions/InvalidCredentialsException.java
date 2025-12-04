package com.mercadona.pruebt.demo.application.exceptions;

public class InvalidCredentialsException extends PruebatException{

  public InvalidCredentialsException(String username) {
    super(ErrorCode.NOT_REGISTERED, username);
  }

}
