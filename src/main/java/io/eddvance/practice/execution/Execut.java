package io.eddvance.practice.execution;

import io.eddvance.practice.App;
import io.eddvance.practice.choices.choice_number.NumberToChoice;
import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.translation.data.FrenchTranslation;
import io.eddvance.practice.translation.data.GermanTranslation;
import io.eddvance.practice.translation.translator.SearchAndReturn;

import java.util.Scanner;
import java.util.logging.Logger;

public class Execut {

    public void action() {
        final Logger logger = Logger.getLogger(App.class.getName());
        final Scanner scanner = new Scanner(System.in);
        String restart;

        do {
            String translation = getString();
            logger.fine(() -> STR."Your translation is : \{translation}");
            logger.info("Do you want to translate another number? (y)");
            restart = scanner.nextLine();
        }
        while (restart.equalsIgnoreCase("y"));
        logger.warning("Au revoir - Auf Wiedersehen");
    }

    private static String getString() {
        FrenchTranslation frenchTranslation = new FrenchTranslation();
        frenchTranslation.frenchTranslation();
        GermanTranslation germanTranslation = new GermanTranslation();
        germanTranslation.germanTranslation();

        SearchAndReturn searchAndReturn = new SearchAndReturn();
        TranslationToChoice translationToChoice = new TranslationToChoice();
        NumberToChoice numberToChoice = new NumberToChoice();

        int number = numberToChoice.numberChoice();
        int languageSelection = translationToChoice.translationToChoice();

        return searchAndReturn.getTranslation(number, languageSelection);
    }
}