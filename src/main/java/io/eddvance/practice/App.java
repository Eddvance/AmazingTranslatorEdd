package io.eddvance.practice;

import io.eddvance.practice.translatorAmazing.service.Execut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private Execut execut;

    public App(Execut execut) {
        this.execut = execut;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        execut.action();
    }
}