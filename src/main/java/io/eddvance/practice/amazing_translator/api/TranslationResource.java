package io.eddvance.practice.amazing_translator.api;

import io.eddvance.practice.amazing_translator.entity.translation.Translation;
import io.eddvance.practice.amazing_translator.service.TranslationServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationResource {
    private final TranslationServiceInterface translationService;

    public TranslationResource(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/list")
    public List<Translation> getAll() {
        return translationService.findAll();
    }

    @GetMapping("/search/{number}")
    public ResponseEntity<?> searchByPath(@PathVariable("number") int number) {
        Translation found = translationService.findByNumber(number);
            return ResponseEntity.ok(found);
    }
}