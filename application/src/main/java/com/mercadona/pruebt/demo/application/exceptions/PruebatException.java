package com.mercadona.pruebt.demo.application.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PruebatException extends RuntimeException {

    private final ErrorCode code;
    private List<String> details;
    private final Object[] parameters;

    public PruebatException(ErrorCode code, Object... parameters) {
        super();
        this.code = code;
        this.parameters = parameters;
        this.details = new ArrayList<>();
    }
}
