package io.eddvance.practice.exceptions;

public class NumberAskedCantNotBeEmpty extends RuntimeException{
    public NumberAskedCantNotBeEmpty() {
         super("Input cannot be empty. Please try again.");
    }
}
