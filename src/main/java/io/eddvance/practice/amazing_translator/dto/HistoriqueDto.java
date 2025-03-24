package io.eddvance.practice.amazing_translator.dto;

import java.time.LocalDateTime;

public class HistoriqueDto {
    private Long id;
    private Integer nombre;
    private String langue;
    private LocalDateTime localDateTime;

    public HistoriqueDto() {
    }

    public HistoriqueDto(Long id, Integer nombre, String langue, LocalDateTime localDateTime) {
        this.id = id;
        this.nombre = nombre;
        this.langue = langue;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}