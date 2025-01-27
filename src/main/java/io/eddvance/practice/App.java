package io.eddvance.practice;

import io.eddvance.practice.translatorAmazing.controller.TranslatorConsoleController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private TranslatorConsoleController controller;

    public App(TranslatorConsoleController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.action();
    }
}