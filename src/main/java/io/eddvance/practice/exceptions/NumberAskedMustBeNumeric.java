package io.eddvance.practice.exceptions;

public class NumberAskedMustBeNumeric extends RuntimeException {

    public NumberAskedMustBeNumeric(int number) {
        super(STR."The number \{number} is out of range. Must be between 1 and 30.");
    }

    public NumberAskedMustBeNumeric(String failedInput) {
        super(STR."Invalid input \{failedInput}'. Please enter a numeric value.");
    }
}