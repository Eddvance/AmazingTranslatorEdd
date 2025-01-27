package io.eddvance.practice.translatorAmazing.exception;

public class NumberAskedMustBe1to30 extends RuntimeException {
    public NumberAskedMustBe1to30(int number) {
        super(STR."The number \{number} is out of range. Must be between 1 and 30.");
    }
}
