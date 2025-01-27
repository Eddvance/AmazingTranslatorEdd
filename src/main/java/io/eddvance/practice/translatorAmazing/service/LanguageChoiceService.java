package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.exception.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.translatorAmazing.exception.NumberAskedMustBeNumeric;
import io.eddvance.practice.translatorAmazing.exception.NumberMustBe1Or2;
import io.eddvance.practice.translatorAmazing.util.InputReader;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LanguageChoiceService {

    private final InputReader inputReader;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private int languageSelection;

    public LanguageChoiceService(InputReader inputReader) {
        this.inputReader = inputReader != null ? inputReader : new InputReader();
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public LanguageChoiceService() {
        this(new InputReader());
    }

    public int getLanguageSelection() {
        return languageSelection;
    }

    public void setLanguageSelection(int languageSelection) {
        this.languageSelection = languageSelection;
    }

    public int translationToChoice() {
        while (true) {
            try {
                return translationChoiceEach();
            } catch (NumberAskedCantNotBeEmpty | NumberMustBe1Or2 | NumberAskedMustBeNumeric e) {
                logger.info(e.getMessage());
            }
        }
    }

    public int translationChoiceEach() {
        logger.info("What is language (1-French, 2-German)?");
        String optionAsString = inputReader.readLine();
        if (optionAsString == null || optionAsString.isEmpty()) {
            throw new NumberAskedCantNotBeEmpty();
        }
        try {
            languageSelection = Integer.parseInt(optionAsString);
            if (languageSelection != 1 && languageSelection != 2) {
                throw new NumberMustBe1Or2(languageSelection);
            }

        } catch (NumberFormatException nfe) {
            throw new NumberAskedMustBeNumeric(optionAsString);
        }
        return languageSelection;
    }
}