package io.eddvance.practice;

import io.eddvance.practice.translatorAmazing.execution.Execut;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        Execut execut = new Execut();
        execut.init();
        execut.action();
    }
}