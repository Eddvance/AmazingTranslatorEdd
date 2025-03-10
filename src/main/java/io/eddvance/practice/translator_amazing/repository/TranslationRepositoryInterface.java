package io.eddvance.practice.translator_amazing.repository;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepositoryInterface extends JpaRepository<Translation, Long> {
    Translation findByNumber(int number);
}