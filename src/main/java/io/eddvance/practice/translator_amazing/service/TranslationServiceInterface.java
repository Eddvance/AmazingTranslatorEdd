package io.eddvance.practice.translator_amazing.service;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;

public interface TranslationServiceInterface {
    Translation findByNumber(int number);
}