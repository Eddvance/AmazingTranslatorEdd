package io.eddvance.practice.search;

import java.util.logging.Logger;

import static io.eddvance.practice.translation_directory.FrenchTranslation.getFrenchTranslations;
import static io.eddvance.practice.translation_directory.GermanTranslation.getGermanTranslations;

public class SearchAndReturn {

    public String getTranslation(Integer number, int languageSelection) {

        String translation = null;
        Logger logger = Logger.getLogger(getClass().getName());

        if (languageSelection == 1) {
            if (number > 0 && number <= getFrenchTranslations().size()) {
                translation = getFrenchTranslations().get(number - 1);
                logger.info(STR."The number \{number} in french is : \{translation}");
            } else {
                logger.severe("Invalid number, please enter a number between 1 and 30.");
            }

        } else if (languageSelection == 2) {
            if (number > 0 && number <= getGermanTranslations().size()) {
                translation = getGermanTranslations().get(number - 1);
                logger.info(STR."The number \{number} in German is : \{translation}");
            } else {
                logger.severe("Invalid number, please enter a number between 1 and 30.");
            }
        }
        return translation;
    }
}