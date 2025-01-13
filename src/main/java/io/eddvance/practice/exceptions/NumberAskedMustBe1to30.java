package io.eddvance.practice.exceptions;

import io.eddvance.practice.choices.choice_number.NumberToChoice;

public class NumberAskedMustBe1to30 extends RuntimeException {

    public NumberAskedMustBe1to30(int number) {
        String message = "The number "+number+" is out of range. Must be between 1 and 30.";
    }
}
