package io.eddvance.practice.translator_amazing.exception.translation_not_found_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

import java.net.URI;

public class TranslationNotFoundException extends RuntimeException implements ErrorResponse {

    private final ProblemDetail body;

    public TranslationNotFoundException(int number) {
        super("No translation found for number " + number);
        this.body = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, getMessage());
        body.setTitle("Translation not found");
        body.setType(URI.create("https://api.example.com/errors/not-found"));
        body.setInstance(URI.create("/translations/" + number));
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public ProblemDetail getBody() {
        return body;
    }
}