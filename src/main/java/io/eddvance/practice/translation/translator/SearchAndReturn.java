package io.eddvance.practice.translation.translator;

import io.eddvance.practice.interaction.InputReader;

import java.util.logging.Logger;

import static io.eddvance.practice.translation.data.FrenchTranslation.getFrenchTranslations;
import static io.eddvance.practice.translation.data.GermanTranslation.getGermanTranslations;

public class SearchAndReturn {


    public String getTranslation(Integer number, int languageSelection) {

        String translation = null;
        Logger logger = Logger.getLogger(getClass().getName());

        if (languageSelection == 1) {
            if (number > 0 && number <= getFrenchTranslations().size()) {
                translation = getFrenchTranslations().get(number - 1);
                logger.info(STR."The number \{number} in french is : \{translation}");
            }

        } else if (languageSelection == 2) {
            if (number > 0 && number <= getGermanTranslations().size()) {
                translation = getGermanTranslations().get(number - 1);
                logger.info(STR."The number \{number} in German is : \{translation}");
            }
        }
        return translation;
    }
}