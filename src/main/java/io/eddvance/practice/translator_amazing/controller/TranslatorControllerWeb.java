package io.eddvance.practice.translator_amazing.controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Translation> translations = translationService.findAll();
        model.addAttribute("translations", translations);
        return "translations-list";
    }

    @GetMapping("/search")
    public String searchTranslation(Model model, @RequestParam("number") int number) {
        Translation translation = translationService.findByNumber(number);
        if (translation == null) {
            model.addAttribute("error", "Traduction non trouvée pour le nombre " + number);
        } else {
            model.addAttribute("translation", translation);
        }
        return "translation-search";
    }
}