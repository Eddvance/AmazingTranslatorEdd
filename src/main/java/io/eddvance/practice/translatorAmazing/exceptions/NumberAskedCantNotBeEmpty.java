package io.eddvance.practice.translatorAmazing.exceptions;

public class NumberAskedCantNotBeEmpty extends RuntimeException{
    public NumberAskedCantNotBeEmpty() {
         super("Input cannot be empty. Please try again.");
    }
}
