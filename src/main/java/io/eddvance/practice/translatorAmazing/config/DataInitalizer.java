package io.eddvance.practice.translatorAmazing.config;

import io.eddvance.practice.translatorAmazing.repository.TranslationRepository;
import org.springframework.boot.CommandLineRunner;

public class DataInitalizer implements CommandLineRunner {

    private final TranslationRepository translationRepository;

    public DataInitalizer(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public void run(String... args) {
    }

}