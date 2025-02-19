package io.eddvance.practice.translator_amazing.config;

import io.eddvance.practice.translator_amazing.repository.TranslationRepositoryInterface;
import org.springframework.boot.CommandLineRunner;

public class DataInitalizer implements CommandLineRunner {

    private final TranslationRepositoryInterface translationRepository;

    public DataInitalizer(TranslationRepositoryInterface translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public void run(String... args) {
    }

}