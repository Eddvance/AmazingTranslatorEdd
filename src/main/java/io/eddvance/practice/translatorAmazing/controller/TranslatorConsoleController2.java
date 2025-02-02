package io.eddvance.practice.translatorAmazing.controller;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import io.eddvance.practice.translatorAmazing.repository.TranslationRepositoryInterface;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;

import java.util.List;
import java.util.logging.Logger;

public class TranslatorConsoleController2 {

    private final Logger logger = Logger.getLogger(TranslationSearchService.class.getName());
    private final TranslationRepositoryInterface translationRepository;

    public TranslatorConsoleController2(TranslationRepositoryInterface translationRepository) {
        this.translationRepository = translationRepository;
    }

    /**
     * Récupère la traduction française pour une position donnée (1, 2, 3, ...).
     * @param position index (ex: 10 = "Dix")
     * @return texte traduit en français, ou null si non trouvé
     */
    public String getFrenchWord(int position) {
        Translation translation = translationRepository.findByLanguageAndPosition("FR", position);
        return (translation != null) ? translation.getText() : null;
    }

    /**
     * Récupère la traduction allemande pour une position donnée (1, 2, 3, ...).
     * @param position index (ex: 10 = "Zehn")
     * @return texte traduit en allemand, ou null si non trouvé
     */
    public String getGermanWord(int position) {
        Translation translation = translationRepository.findByLanguageAndPosition("DE", position);
        return (translation != null) ? translation.getText() : null;
    }

    /**
     * Renvoie la liste de toutes les traductions allemandes,
     * classées par position croissante (1...30).
     */
    public List<Translation> getAllGermanWords() {
        return translationRepository.findByLanguageOrderByPositionAsc("DE");
    }

    /**
     * Renvoie la liste de toutes les traductions françaises,
     * classées par position croissante (1...30).
     */
    public List<Translation> getAllFrenchWords() {
        return translationRepository.findByLanguageOrderByPositionAsc("FR");
    }
}
