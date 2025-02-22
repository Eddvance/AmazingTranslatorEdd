package io.eddvance.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TranslationNotFoundException extends ResponseStatusException {

    public TranslationNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}