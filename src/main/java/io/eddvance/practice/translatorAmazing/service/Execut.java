package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.App;
import io.eddvance.practice.translatorAmazing.interaction.InputReader;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class Execut {

    private final Logger logger = Logger.getLogger(App.class.getName());

    private final InputReader inputReader;

    private final SearchAndReturn searchAndReturn;
    private final TranslationToChoice translationToChoice;
    private final NumberToChoice numberToChoice;

    public Execut(InputReader inputReader,SearchAndReturn searchAndReturn, TranslationToChoice translationToChoice, NumberToChoice numberToChoice) {
        this.inputReader = inputReader;
        this.searchAndReturn = searchAndReturn;
        this.translationToChoice = translationToChoice;
        this.numberToChoice = numberToChoice;
    }

    public void action() {
        String restart;

        do {
            String translation = getString();
            logger.fine(() -> STR."Your translation is : \{translation}");
            logger.info("Do you want to translate another number? (y)");
            restart = inputReader.readLine();
        }
        while (restart.equalsIgnoreCase("y"));
        logger.warning("Au revoir - Auf Wiedersehen");
    }

    private String getString() {

        int number = numberToChoice.numberChoice();
        int languageSelection = translationToChoice.translationToChoice();
        return searchAndReturn.getTranslation(number, languageSelection);
    }
}