package io.eddvance.practice.translator_amazing.exception.number_must_be_1_or_2;

public class NumberMustBe1Or2 extends RuntimeException {
    public NumberMustBe1Or2(int number) {
        super(STR."The number : \{number} is out of range. Must be between 1 and 30.");
    }

    public NumberMustBe1Or2(String failedInput) {
        super(STR."Invalid input : \{failedInput}. Please enter a numeric value.");
    }
}