package io.eddvance.practice.translator_amazing.exception.translation_not_found_exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


public class TranslationNotFoundException extends ResponseStatusException {

    public TranslationNotFoundException(HttpStatusCode status) {
        super(status);
    }

    public TranslationNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public TranslationNotFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public TranslationNotFoundException(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    protected TranslationNotFoundException(HttpStatusCode status, String reason, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
        super(status, reason, cause, messageDetailCode, messageDetailArguments);
    }
}