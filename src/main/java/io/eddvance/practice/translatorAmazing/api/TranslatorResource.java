package io.eddvance.practice.translatorAmazing.api;


import io.eddvance.practice.translatorAmazing.entite.Translation;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class TranslatorResource {

    private TranslationSearchService translationSearchService;

    public TranslatorResource(TranslationSearchService translationSearchService) {
        this.translationSearchService = translationSearchService;
    }



}
