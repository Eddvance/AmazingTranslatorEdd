package io.eddvance.practice.translatorAmazing.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }
}