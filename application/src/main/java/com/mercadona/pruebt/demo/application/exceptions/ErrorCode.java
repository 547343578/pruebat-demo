package com.mercadona.pruebt.demo.application.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

  EXAMPLE_EXCEPTION("PRT-01"),
  PRODUCT_NOT_FOUND("PRT-02"),
  PATCH_EXCEPTION("PRT-03");

  private final String code;

  ErrorCode(String code) {
    this.code = code;
  }

}

