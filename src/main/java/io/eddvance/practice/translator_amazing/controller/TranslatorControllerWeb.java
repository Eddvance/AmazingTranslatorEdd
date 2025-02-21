package io.eddvance.practice.translator_amazing.controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/translations")
public class TranslatorControllerWeb {

    private final TranslationServiceInterface translationService;
    public TranslatorControllerWeb(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/list")
    public String listTranslations(Model model) {
        List<Translation> translations = translationService.findAll();
        model.addAttribute("translations", translations);
        return "translations-list";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("translation", new Translation());
        return "translation-search";
    }

    @PostMapping("/search")
    public String processSearch(@Valid @ModelAttribute("translation") Translation translation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "translation-search";
        }
        int number = translation.getNumber();
        Translation result = translationService.findByNumber(number);
        model.addAttribute("result", result);
        return "translation-result";
    }
}