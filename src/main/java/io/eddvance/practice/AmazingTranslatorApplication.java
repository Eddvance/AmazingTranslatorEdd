package io.eddvance.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages = "io.eddvance.practice.amazing_translator")
public class AmazingTranslatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazingTranslatorApplication.class, args);
    }

}