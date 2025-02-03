package io.eddvance.practice.translatorAmazing.controller.api_rest;


import io.eddvance.practice.translatorAmazing.controller.api_rest.dto.TranslationResponse;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TranslatorResource {
    private final TranslationSearchService translationSearchService;

    public TranslatorResource(TranslationSearchService translationSearchService) {
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