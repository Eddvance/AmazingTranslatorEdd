package io.eddvance.practice.translatorAmazing.repository;

import io.eddvance.practice.translatorAmazing.entity_model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {
    Translation findByLanguageAndPosition(String language, int position);
}
