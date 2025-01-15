package io.eddvance.practice.execution;

import io.eddvance.practice.App;
import io.eddvance.practice.choices.choice_number.NumberToChoice;
import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.interaction.InputReader;
import io.eddvance.practice.translation.data.FrenchTranslation;
import io.eddvance.practice.translation.data.GermanTranslation;
import io.eddvance.practice.translation.translator.SearchAndReturn;

import java.util.logging.Logger;

public class Execut {
    private final Logger logger = Logger.getLogger(App.class.getName());
    private InputReader inputReader;
    private final FrenchTranslation frenchTranslation = new FrenchTranslation();
    private final GermanTranslation germanTranslation = new GermanTranslation();
    private final SearchAndReturn searchAndReturn = new SearchAndReturn();
    private final TranslationToChoice translationToChoice = new TranslationToChoice();
    private final NumberToChoice numberToChoice = new NumberToChoice();
    public Execut() {
        this.inputReader = new InputReader();
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
        frenchTranslation.frenchTranslation();
        germanTranslation.germanTranslation();

        int number = numberToChoice.numberChoice();
        int languageSelection = translationToChoice.translationToChoice();
        return searchAndReturn.getTranslation(number, languageSelection);
    }
}