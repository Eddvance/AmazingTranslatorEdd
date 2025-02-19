package io.eddvance.practice.translator_amazing.controller.api_rest.translation_resource;


import io.eddvance.practice.translator_amazing.controller.api_rest.dto.TranslationResponse;
import io.eddvance.practice.translator_amazing.service.TranslationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TranslatorResource {
    private final TranslationService translationSearchService;

    public TranslatorResource(TranslationService translationSearchService) {
        this.translationSearchService = translationSearchService;
    }

    @GetMapping("/translate")
    public TranslationResponse translate(
            @RequestParam(name = "language") String language,
            @RequestParam(name = "position") int position
    ) {

        String text = translationSearchService.getTranslation(language.toUpperCase(), position);
        if (text == null) {
            return new TranslationResponse(null, "Translation not found for position " + position);
        } else {
            return new TranslationResponse(text, null);
        }
    }
}