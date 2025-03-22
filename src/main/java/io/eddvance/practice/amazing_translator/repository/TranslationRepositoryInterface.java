package io.eddvance.practice.amazing_translator.repository;

import io.eddvance.practice.amazing_translator.entity.translation.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepositoryInterface extends JpaRepository<Translation, Long> {
    Translation findByNumber(int number);
}