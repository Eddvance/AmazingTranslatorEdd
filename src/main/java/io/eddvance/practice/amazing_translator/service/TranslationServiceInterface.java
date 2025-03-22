package io.eddvance.practice.amazing_translator.service;

import io.eddvance.practice.amazing_translator.entity.translation.Translation;

import java.util.List;

public interface TranslationServiceInterface {
    Translation findByNumber(int number);

    List<Translation> findAll();

}