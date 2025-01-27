package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.repository.FrenchTranslationRepository;
import io.eddvance.practice.translatorAmazing.repository.GermanTranslationRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TranslationSearchService {

    private final FrenchTranslationRepository frenchTranslation;
    private final GermanTranslationRepository germanTranslation;

    public TranslationSearchService(GermanTranslationRepository germanTranslation, FrenchTranslationRepository frenchTranslation) {
        this.germanTranslation = germanTranslation;
        this.frenchTranslation = frenchTranslation;
    }

    public String getTranslation(Integer number, int languageSelection) {

        String translation = null;
        Logger logger = Logger.getLogger(getClass().getName());

        if (languageSelection == 1) {
            if (number > 0 && number <= frenchTranslation.getAll().size()) {
                translation = frenchTranslation.getAll().get(number - 1);
                logger.info(STR."The number \{number} in french is : \{translation}");
            }

        } else if (languageSelection == 2) {
            if (number > 0 && number <= germanTranslation.getAll().size()) {
                translation = germanTranslation.getAll().get(number - 1);
                logger.info(STR."The number \{number} in German is : \{translation}");
            }
        }
        return translation;
    }
}