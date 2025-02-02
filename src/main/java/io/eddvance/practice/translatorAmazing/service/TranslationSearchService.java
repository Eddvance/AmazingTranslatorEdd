package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import io.eddvance.practice.translatorAmazing.repository.TranslationRepositoryInterface;

public class TranslationSearchService {
    private final TranslationRepositoryInterface translationRepository;

    public TranslationSearchService(TranslationRepositoryInterface translationRepository) {
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


}
