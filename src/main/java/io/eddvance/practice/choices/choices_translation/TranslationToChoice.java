package io.eddvance.practice.choices.choices_translation;

import io.eddvance.practice.interaction.InputReader;

import java.util.Scanner;
import java.util.logging.Logger;

public class TranslationToChoice {

    private final InputReader inputReader;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private int languageSelection;

    public TranslationToChoice(InputReader inputReader) {
        this.inputReader = inputReader != null ? inputReader : new InputReader();
    }

    public TranslationToChoice() {
        this(new InputReader());
    }

    public TranslationToChoice(InputReader mockInputReader, InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int getLanguageSelection() {
        return languageSelection;
    }

    public void setLanguageSelection(int languageSelection) {
        this.languageSelection = languageSelection;
    }


    public int translationChoice() {

        boolean inputValid = false;
        while (!inputValid) {

            logger.info("What is language (1-French, 2-German)?");
            String optionAsString = inputReader.readLine();

            if (optionAsString == null || optionAsString.isEmpty()) {
                logger.severe("Input cannot be empty. Please try again.");
                continue;
            }

            try {
                languageSelection = Integer.parseInt(optionAsString);
                if (languageSelection == 1 || languageSelection == 2) {
                    inputValid = true;
                } else {
                    logger.severe("Please enter a valid option: 1 for French, 2 for German.");
                }
            } catch (NumberFormatException nfe) {
                logger.severe("The languageSelection had to be numeric");
            }
        }
        return languageSelection;
    }
}