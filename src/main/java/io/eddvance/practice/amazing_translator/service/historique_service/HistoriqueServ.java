package io.eddvance.practice.amazing_translator.service.historique_service;

import io.eddvance.practice.amazing_translator.dto.HistoriqueDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class HistoriqueServ {

    private final RestTemplate restTemplate;
    private final String historiqueServiceUrl = "http://localhost:804/historique/add";

    public HistoriqueServ(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addHistorique(HistoriqueDto historiqueDto) {
        restTemplate.postForObject(historiqueServiceUrl, historiqueDto, String.class);
    }

    public void addHistorique(int nombre, String langue) {
        HistoriqueDto historiqueDto = new HistoriqueDto(
                null,
                nombre,
                langue,
                LocalDateTime.now()
        );
        addHistorique(historiqueDto);
    }
}
