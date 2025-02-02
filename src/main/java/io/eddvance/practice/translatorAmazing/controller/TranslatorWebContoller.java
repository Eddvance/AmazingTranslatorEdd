package io.eddvance.practice.translatorAmazing.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TranslatorWebContoller {

    @GetMapping("/translate")
    public String displayHome(Model model){
        System.out.println("La méthode display Home a été invoquée");
        return "translator";
    }

}
