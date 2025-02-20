package io.eddvance.practice.translator_amazing.entity.translation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Language cannot be empty.")
    @Size(min = 2, max = 2, message = "Language must be 2 characters.")
    private String language;

    @NotBlank(message = "Cannot be empty.")
    @Min(value = 1, message = "Position must be at least 1")
    @Max(value = 30, message = "Position must be at most 30")
    private int position;

    @NotBlank(message = "Text cannot be empty.")
    @Size(min = 1, max = 255, message = "Text must be between 1 and 255 characters.")
    private String text;

    public Translation() {
    }

    public Translation(String language, int position, String text) {
        this.language = language;
        this.position = position;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}