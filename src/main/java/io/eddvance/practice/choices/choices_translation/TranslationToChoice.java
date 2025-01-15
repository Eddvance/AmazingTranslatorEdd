package io.eddvance.practice.choices.choices_translation;

import io.eddvance.practice.exceptions.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.exceptions.NumberAskedMustBeNumeric;
import io.eddvance.practice.exceptions.NumberMustBe1Or2;
import io.eddvance.practice.interaction.InputReader;

import java.util.logging.Logger;

public class TranslationToChoice {

    private final InputReader inputReader;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private int languageSelection;

    public TranslationToChoice(InputReader inputReader) {
        this.inputReader = inputReader != null ? inputReader : new InputReader();
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public TranslationToChoice() {
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
                throw new NumberMustBe1Or2();
            }

        } catch (NumberFormatException nfe) {
            throw new NumberAskedMustBeNumeric(optionAsString);
        }
        return languageSelection;
    }
}