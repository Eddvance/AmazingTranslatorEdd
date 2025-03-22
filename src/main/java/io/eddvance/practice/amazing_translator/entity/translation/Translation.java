package io.eddvance.practice.amazing_translator.entity.translation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Le nombre doit être entre 1 et 30")
    @Max(value = 30, message = "Le nombre doit être entre 1 et 30")
    private int number;

    @NotBlank(message = "La traduction en français ne peut être vide.")
    private String french;

    @NotBlank(message = "La traduction en allemand ne peut être vide.")
    private String german;

    public Translation() {
    }

    public Translation(int number, String french, String german) {
        this.number = number;
        this.french = french;
        this.german = german;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }
}