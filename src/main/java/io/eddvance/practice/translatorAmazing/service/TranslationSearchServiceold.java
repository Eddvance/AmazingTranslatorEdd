/*package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.repository.TranslationRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TranslationSearchServiceold {

    //private final FrenchTranslationRepository frenchTranslation;
    //private final GermanTranslationRepository germanTranslation;
    private final TranslationRepositoryInterface translationRepository;

    public TranslationSearchServiceold(TranslationRepositoryInterface translationRepository) {
        this.translationRepository = translationRepository;
    }


    public String getTranslation(Integer number, int languageSelection) {

        String translation = null;
        Logger logger = Logger.getLogger(getClass().getName());

        if (languageSelection == 1) {
            if (number > 0 && number <= translationRepository.getAll().size()) {
                translation = translationRepository.getAll().get(number - 1);
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

 */