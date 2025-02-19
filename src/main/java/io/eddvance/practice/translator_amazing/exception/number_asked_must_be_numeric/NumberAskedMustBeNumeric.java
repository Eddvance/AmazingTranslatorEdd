package io.eddvance.practice.translator_amazing.exception.number_asked_must_be_numeric;

public class NumberAskedMustBeNumeric extends RuntimeException {

    public NumberAskedMustBeNumeric(int number) {
        super(STR."The number \{number} is out of range. Must be between 1 and 30.");
    }

    public NumberAskedMustBeNumeric(String failedInput) {
        super(STR."Invalid input \{failedInput}'. Please enter a numeric value.");
    }
}