package io.eddvance.practice.translator_amazing.controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/translations")
public class TranslatorControllerWeb {

    private final TranslationServiceInterface translationService;

    public TranslatorControllerWeb(TranslationServiceInterface translationService) {
        this.translationService = translationService;
    }

    @GetMapping
    public String listTranslations(Model model) {
        List<Translation> translations = translationService.findAll();
        model.addAttribute("translations", translations);
        return "translations-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("translation", new Translation());
        return "translation-form";
    }

    @PostMapping
    public String createTranslation(@Valid @ModelAttribute("translation") Translation translation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "translation-form";
        }
        translationService.createTranslation(translation);
        return "redirect:/translations";
    }
}