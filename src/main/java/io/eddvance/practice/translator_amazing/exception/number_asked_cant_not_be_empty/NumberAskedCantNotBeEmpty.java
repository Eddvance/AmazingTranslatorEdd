package io.eddvance.practice.translator_amazing.exception.number_asked_cant_not_be_empty;

public class NumberAskedCantNotBeEmpty extends RuntimeException{
    public NumberAskedCantNotBeEmpty() {
         super("Input cannot be empty. Please try again.");
    }
}
