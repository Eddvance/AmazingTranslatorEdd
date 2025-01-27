package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.repository.FrenchTranslation;
import io.eddvance.practice.translatorAmazing.repository.GermanTranslation;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SearchAndReturn {

    private final FrenchTranslation frenchTranslation;
    private final GermanTranslation germanTranslation;

    public SearchAndReturn(GermanTranslation germanTranslation, FrenchTranslation frenchTranslation) {
        this.germanTranslation = germanTranslation;
        this.frenchTranslation = frenchTranslation;
    }

    public String getTranslation(Integer number, int languageSelection) {

        String translation = null;
        Logger logger = Logger.getLogger(getClass().getName());

        if (languageSelection == 1) {
            if (number > 0 && number <= frenchTranslation.getFrenchTranslations().size()) {
                translation = frenchTranslation.getFrenchTranslations().get(number - 1);
                logger.info(STR."The number \{number} in french is : \{translation}");
            }

        } else if (languageSelection == 2) {
            if (number > 0 && number <= germanTranslation.getGermanTranslations().size()) {
                translation = germanTranslation.getGermanTranslations().get(number - 1);
                logger.info(STR."The number \{number} in German is : \{translation}");
            }
        }
        return translation;
    }
}