package io.eddvance.practice.translator_amazing.service;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;

import java.util.List;

public interface TranslationServiceInterface {
    Translation findByNumber(int number);

    List<Translation> findAll();
}