package io.eddvance.practice.translatorAmazing.config;

import io.eddvance.practice.translatorAmazing.entity_model.Translation;
import io.eddvance.practice.translatorAmazing.repository.TranslationRepository;
import org.springframework.boot.CommandLineRunner;

public class DataInitalizer implements CommandLineRunner {

    private final TranslationRepository translationRepository;

    public DataInitalizer(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public void run(String... args) {
        if (translationRepository.count() == 0) {
            translationRepository.save(new Translation("FR", 1, "Un"));
            translationRepository.save(new Translation("FR", 2, "Deux"));
            // ...
            translationRepository.save(new Translation("DE", 1, "Eins"));
            translationRepository.save(new Translation("DE", 2, "Zwei"));
            // ...
        }
    }
}