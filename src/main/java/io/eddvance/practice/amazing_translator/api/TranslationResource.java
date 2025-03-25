package io.eddvance.practice.amazing_translator.api;

import io.eddvance.practice.amazing_translator.entity.translation.Translation;
import io.eddvance.practice.amazing_translator.exception.translation_not_found_exception.TranslationNotFoundException;
import io.eddvance.practice.amazing_translator.service.TranslationServiceInterface;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/translations")

public class TranslationResource {
    private final TranslationServiceInterface translationService;
    public TranslationResource(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }


    @GetMapping("/home")
    public String home() {
        return "welcome";
    }

    @GetMapping("/list")
    public List<Translation> getAll() {
        return translationService.findAll();
    }

    @GetMapping("/search/{number}")
    public ResponseEntity<?> searchByPath(@PathVariable("number") int number) {
        Translation found = translationService.findByNumber(number);
        if (found == null) {
            throw new TranslationNotFoundException(HttpStatusCode.valueOf(404), "La traduction avec le nombre " + number + " est introuvable.");
        }

        return ResponseEntity.ok(found);
    }
}