package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.exception.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.translatorAmazing.exception.NumberAskedMustBe1to30;
import io.eddvance.practice.translatorAmazing.exception.NumberAskedMustBeNumeric;
import io.eddvance.practice.translatorAmazing.util.InputReader;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NumberChoiceService {

    private final InputReader inputReader;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public NumberChoiceService(InputReader inputReader) throws NumberAskedMustBe1to30 {
        this.inputReader = inputReader != null ? inputReader : new InputReader();
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public NumberChoiceService() {
        this(new InputReader());
    }


    public int numberChoice() {
        while (true) {
            try {
                return numberChoiceEach();
            } catch (NumberAskedMustBe1to30 | NumberAskedCantNotBeEmpty | NumberAskedMustBeNumeric e) {
                logger.info(e.getMessage());
            }
        }
    }

    public int numberChoiceEach() throws NumberAskedMustBe1to30, NumberAskedCantNotBeEmpty, NumberAskedMustBeNumeric {
        int numberAskedInt;
        logger.info("What is the number to translate?");
        String numberAskedAsString = inputReader.readLine();
        if (numberAskedAsString == null || numberAskedAsString.isEmpty()) {
            throw new NumberAskedCantNotBeEmpty();
        }
        try {
            numberAskedInt = Integer.parseInt(numberAskedAsString);
            if (numberAskedInt < 1 || numberAskedInt > 30) {
                throw new NumberAskedMustBe1to30(numberAskedInt);
            }
            return numberAskedInt;
        } catch (NumberFormatException e) {
            throw new NumberAskedMustBeNumeric(numberAskedAsString);
        }
    }
}