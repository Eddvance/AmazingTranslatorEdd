package io.eddvance.practice.choices.choice_number;

import io.eddvance.practice.exceptions.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.exceptions.NumberAskedMustBe1to30;
import io.eddvance.practice.exceptions.NumberAskedMustBeNumeric;
import io.eddvance.practice.interaction.InputReader;

import java.util.logging.Logger;

public class NumberToChoice {

    private final InputReader inputReader;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public NumberToChoice(InputReader inputReader) throws NumberAskedMustBe1to30 {
        this.inputReader = inputReader != null ? inputReader : new InputReader();
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public NumberToChoice() {
        this(new InputReader());
    }


    public int numberChoice() {

        while (true) {
            try {
                return numberChoiceEach();
            } catch (NumberAskedMustBe1to30 | NumberAskedCantNotBeEmpty | NumberAskedMustBeNumeric e) {
                continue;
            }
        }

    }

    public int numberChoiceEach() throws NumberAskedMustBe1to30, NumberAskedCantNotBeEmpty, NumberAskedMustBeNumeric {

        try {
            logger.info("What is the number to translate?");
            String numberAskedAsString = inputReader.readLine();

            if (numberAskedAsString == null || numberAskedAsString.isEmpty()) {
                //logger.warning("Input cannot be empty. Please try again.");
                throw new NumberAskedCantNotBeEmpty("Input cannot be empty. Please try again.");
                //
            }

            int numberAskedInt = Integer.parseInt(numberAskedAsString);

            if (numberAskedInt < 1 || numberAskedInt > 30) {
                //logger.warning("Please enter a number between 1 and 30.");
                throw new NumberAskedMustBe1to30();
                //continue;
            }

            return numberAskedInt;

        } catch (NumberFormatException e) {
            throw new NumberAskedMustBeNumeric("Invalid input. Please enter a valid number.");
        }

    }
}