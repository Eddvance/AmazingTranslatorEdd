package io.eddvance.practice.exceptions;

public class NumberAskedMustBeNumeric extends RuntimeException {

    public NumberAskedMustBeNumeric(int number) {
        String message = "The number " + number + " is out of range. Must be between 1 and 30.";
    }
}
