package io.eddvance.practice.exceptions;

public class NumberAskedCantNotBeEmpty extends RuntimeException{
    public NumberAskedCantNotBeEmpty() {
        String message = "Input cannot be empty. Please try again.";
    }
}
