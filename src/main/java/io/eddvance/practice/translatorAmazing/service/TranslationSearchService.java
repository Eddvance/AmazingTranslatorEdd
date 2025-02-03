package io.eddvance.practice.translatorAmazing.service;

import io.eddvance.practice.translatorAmazing.entity_model.Translation;
import io.eddvance.practice.translatorAmazing.repository.TranslationRepository;
import org.springframework.stereotype.Service;

@Service
public class TranslationSearchService {

    private final TranslationRepository translationRepository;

    public TranslationSearchService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public String getTranslation(String language, int position) {
        Translation tr = translationRepository.findByLanguageAndPosition(language, position);
        return (tr != null) ? tr.getText() : null;
    }
}