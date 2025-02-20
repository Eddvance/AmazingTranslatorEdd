package io.eddvance.practice.translator_amazing.controller;

import io.eddvance.practice.translator_amazing.entity.translation.Translation;
import io.eddvance.practice.translator_amazing.service.TranslationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/translations")
public class TranslatorControllerWeb {

    private final TranslationService translationService;

    public TranslatorControllerWeb(TranslationService translationService) {
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
    public String createTranslation(@ModelAttribute Translation translation) {
        translationService.createTranslation(translation);
        return "redirect:/translations";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Translation> optionalTranslation = translationService.findById(id);
        if (optionalTranslation.isPresent()) {
            model.addAttribute("translation", optionalTranslation.get());
            return "translation-form";
        }
        return "redirect:/translations";
    }

    @PostMapping("/{id}")
    public String updateTranslation(@PathVariable Long id, @ModelAttribute Translation updatedTranslation) {
        translationService.updateTranslation(id, updatedTranslation);
        return "redirect:/translations";
    }

    @GetMapping("/{id}/delete")
    public String deleteTranslation(@PathVariable Long id) {
        translationService.deleteById(id);
        return "redirect:/translations";
    }
}