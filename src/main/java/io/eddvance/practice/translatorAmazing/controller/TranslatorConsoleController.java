package io.eddvance.practice.translatorAmazing.controller;

import io.eddvance.practice.App;
import io.eddvance.practice.translatorAmazing.util.InputReader;
import io.eddvance.practice.translatorAmazing.service.NumberChoiceService;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import io.eddvance.practice.translatorAmazing.service.LanguageChoiceService;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class TranslatorConsoleController {

    private final Logger logger = Logger.getLogger(App.class.getName());

    private final InputReader inputReader;

    private final TranslationSearchService searchAndReturn;
    private final LanguageChoiceService translationToChoice;
    private final NumberChoiceService numberToChoice;

    public TranslatorConsoleController(InputReader inputReader, TranslationSearchService searchAndReturn, LanguageChoiceService translationToChoice, NumberChoiceService numberToChoice) {
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