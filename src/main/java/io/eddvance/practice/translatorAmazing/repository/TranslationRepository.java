package io.eddvance.practice.translatorAmazing.repository;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findByLanguage(String language);
    List<Translation> findByLanguageOrderByPosition(String language);
    Translation findByLanguageAndPosition(String language, int position);
}
