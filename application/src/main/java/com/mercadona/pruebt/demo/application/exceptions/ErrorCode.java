package com.mercadona.pruebt.demo.application.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {

    EXAMPLE_EXCEPTION("MGC-01");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}

