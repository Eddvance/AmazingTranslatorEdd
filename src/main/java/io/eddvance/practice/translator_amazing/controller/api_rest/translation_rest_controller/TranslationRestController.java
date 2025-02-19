package io.eddvance.practice.translator_amazing.controller.api_rest.translation_rest_controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class TranslationRestController {

    private final TranslationServiceInterface translationService;

    public TranslationRestController(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/{id}")
    public Optional<Translation> getTranslation(@PathVariable Long id) {
        return translationService.findById(id);
    }

    @GetMapping
    public List<Translation> getAllTranslations() {
        return translationService.findAll();
    }

    @PostMapping
    public Translation createTranslation(@RequestBody Translation translation) {
        return translationService.save(translation);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslation(@PathVariable Long id) {
        translationService.deleteById(id);
    }
}
