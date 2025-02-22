package io.eddvance.practice.exception.translation_not_found_exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TranslationNotFoundException extends ResponseStatusException {

    public TranslationNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}