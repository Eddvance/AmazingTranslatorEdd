package io.eddvance.practice.translator_amazing.api;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationResource {
    private final TranslationService translationService;

    public TranslationResource(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/list")
    public List<Translation> translationList() {
        return translationService.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchTranslation(@RequestParam("number") int number) {
        Translation translation = translationService.findByNumber(number);
        if (translation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Traduction non trouvée pour le nombre " + number);
        }
        return ResponseEntity.ok(translation);
    }

    @GetMapping("/search/{number}")
    public ResponseEntity<?> processSearch(@PathVariable("number") int number) {
        Translation translation = translationService.findByNumber(number);
        if (translation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Traduction non trouvée pour le nombre " + number);
        }
        return ResponseEntity.ok(translation);
    }
}