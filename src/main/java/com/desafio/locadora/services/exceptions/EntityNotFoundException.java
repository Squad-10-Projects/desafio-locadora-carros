package com.desafio.locadora.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
