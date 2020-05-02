package br.com.matheussvb.exception;

import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
