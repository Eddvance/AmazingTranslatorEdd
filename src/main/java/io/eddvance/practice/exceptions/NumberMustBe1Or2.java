package io.eddvance.practice.exceptions;

public class NumberMustBe1Or2 extends RuntimeException {
    public NumberMustBe1Or2() {
        String message = "Number must be 1 or 2";
    }
}