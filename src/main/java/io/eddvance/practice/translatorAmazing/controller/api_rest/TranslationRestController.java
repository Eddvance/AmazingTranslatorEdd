package io.eddvance.practice.translatorAmazing.controller.api_rest;

import io.eddvance.practice.translatorAmazing.controller.api_rest.dto.TranslationResponse;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TranslationRestController {

    private final TranslationSearchService translationSearchService;

    public TranslationRestController(TranslationSearchService translationSearchService) {
        this.translationSearchService = translationSearchService;
    }

    @GetMapping("/translate")
    public TranslationResponse translate(
            @RequestParam String language,
            @RequestParam int position
    ) {
        String text = translationSearchService.getTranslation(language.toUpperCase(), position);

        if (text == null) {
            return new TranslationResponse(null, "Translation not found for position " + position + " in language " + language);
        }
        return new TranslationResponse(text, null);
    }
}