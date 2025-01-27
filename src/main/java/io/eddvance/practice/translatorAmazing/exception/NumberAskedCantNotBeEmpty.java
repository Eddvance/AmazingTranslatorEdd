package io.eddvance.practice.translatorAmazing.exception;

public class NumberAskedCantNotBeEmpty extends RuntimeException{
    public NumberAskedCantNotBeEmpty() {
         super("Input cannot be empty. Please try again.");
    }
}
