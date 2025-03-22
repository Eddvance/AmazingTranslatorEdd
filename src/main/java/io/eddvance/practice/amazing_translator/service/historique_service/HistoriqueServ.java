package io.eddvance.practice.amazing_translator.service.historique_service;

import io.eddvance.practice.amazing_historique.entity.historique_dto.HistoriqueDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HistoriqueServ {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String historiqueServiceUrl = "http://localhost:804/historique/add";

    public void addHistorique(HistoriqueDto historiqueDto) {
        restTemplate.postForObject(historiqueServiceUrl, historiqueDto, String.class);
    }
}
