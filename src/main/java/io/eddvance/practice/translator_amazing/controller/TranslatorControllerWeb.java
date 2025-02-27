package io.eddvance.practice.translator_amazing.controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.exception.translation_not_found_exception.TranslationNotFoundException;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/translations")
public class TranslatorControllerWeb {

    private final TranslationServiceInterface translationService;

    public TranslatorControllerWeb(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/home")
    public String home() {
        return "translation-home";
    }

    @GetMapping("/list")
    public String listTranslations(Model model) {
        List<Translation> translationList = translationService.findAll();
        model.addAttribute("translations", translationList);
        return "translations-list";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "translation-search";
    }

    @GetMapping("/search/html/{number}")
    public String searchHtml(@PathVariable("number") int number, Model model) {
        if (number < 1 || number > 30) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Erreur! Vous avez saisi " + number + "Le numéro doit être compris entre 1 et 30.");
        }
        try {
            Translation translationFound = translationService.findByNumber(number);
            model.addAttribute("translation", translationFound);
            return "translation-result";

        } catch (TranslationNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune traduction trouvée pour le numéro " + number, ex);
        }
    }
}