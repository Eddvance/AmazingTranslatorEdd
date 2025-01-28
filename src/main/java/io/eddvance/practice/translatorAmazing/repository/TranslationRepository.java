package io.eddvance.practice.translatorAmazing.repository;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
}
