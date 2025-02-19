package io.eddvance.practice.translator_amazing.service;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.repository.TranslationRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationService implements TranslationServiceInterface {

    private final TranslationRepositoryInterface translationRepository;

    public TranslationService(TranslationRepositoryInterface translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public Optional<Translation> findById(Long id) {
        return translationRepository.findById(id);
    }

    @Override
    public List<Translation> findAll() {
        return translationRepository.findAll();
    }

    @Override
    public Translation createTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    @Override
    public Translation updateTranslation(Long id, Translation updatedTranslation) {
        return null;
    }

    @Override
    public void deleteById(Long id) {}

    @Override
    public Translation save(Translation translation) {
        return translationRepository.save(translation);
    }
}