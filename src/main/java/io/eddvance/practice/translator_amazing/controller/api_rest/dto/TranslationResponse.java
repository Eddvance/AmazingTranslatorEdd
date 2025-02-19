package io.eddvance.practice.translator_amazing.controller.api_rest.dto;

public class TranslationResponse {
    private String text;
    private String error;

    public TranslationResponse() {
    }

    public TranslationResponse(String text, String error) {
        this.text = text;
        this.error = error;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}