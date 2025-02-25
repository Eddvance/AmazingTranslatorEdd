package io.eddvance.practice.translator_amazing.api;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import org.springframework.http.HttpStatus;
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
        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Traduction non trouvée pour le nombre " + number);
        }
    }
}