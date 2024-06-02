package com.junio.sistemafinanceiro.exceptionsHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class HttpStatusWrapper {
    private final HttpStatus status;
    private final String message;

    public HttpStatusWrapper(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}