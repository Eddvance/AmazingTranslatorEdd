package io.eddvance.practice.translator_amazing.service;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.repository.TranslationRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService implements TranslationServiceInterface {

    private final TranslationRepositoryInterface translationRepository;

    public TranslationService(TranslationRepositoryInterface translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public Translation findByNumber(int number) {
        return translationRepository.findByNumber(number);
    }

    @Override
    public List<Translation> findAll() {
        return translationRepository.findAll();
    }
}