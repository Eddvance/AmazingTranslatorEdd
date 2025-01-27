package io.eddvance.practice.translatorAmazing.exceptions;

public class NumberMustBe1Or2 extends RuntimeException {
    public NumberMustBe1Or2(int number) {
        super(STR."The number : \{number} is out of range. Must be between 1 and 30.");
    }

    public NumberMustBe1Or2(String failedInput) {
        super(STR."Invalid input : \{failedInput}. Please enter a numeric value.");
    }
}