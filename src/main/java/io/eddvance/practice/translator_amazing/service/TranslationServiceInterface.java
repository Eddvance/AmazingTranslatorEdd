package io.eddvance.practice.translator_amazing.service;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;

import java.util.List;
import java.util.Optional;

public interface TranslationServiceInterface {

    Optional<Translation> findById(Long id);

    List<Translation> findAll();

    Translation createTranslation(Translation translation);

    Translation updateTranslation(Long id, Translation updatedTranslation);

    void deleteById(Long id);

    Translation save(Translation translation);
}