package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import io.eddvance.practice.translatorAmazing.repository.TranslationRepository;
import org.springframework.stereotype.Service;

@Service
public class TranslationSearchService {

    private final TranslationRepository translationRepository;

    public TranslationSearchService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }


    public String getFrenchWord(int position) {
        Translation translation = translationRepository.findByLanguageAndPosition("FR", position);
        return (translation != null) ? translation.getText() : null;
    }


    public String getGermanWord(int position) {
        Translation translation = translationRepository.findByLanguageAndPosition("DE", position);
        return (translation != null) ? translation.getText() : null;
    }

    /*public List<Translation> getAllGermanWords() {
        return translationRepository.findByLanguageOrderByPositionAsc("DE");
    }

    public List<Translation> getAllFrenchWords() {
        return translationRepository.findByLanguageOrderByPositionAsc("FR");
    }
    */

    public Translation saveTranslation(Translation translation) {
        return translationRepository.save(translation);
    }
}