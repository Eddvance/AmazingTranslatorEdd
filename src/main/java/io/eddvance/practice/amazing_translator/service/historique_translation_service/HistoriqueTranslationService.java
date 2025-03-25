package io.eddvance.practice.amazing_translator.service.historique_translation_service;

import io.eddvance.practice.amazing_translator.entity.historique_dto.HistoriqueDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class HistoriqueTranslationService {

    private final RestTemplate restTemplate;
    private final String historiqueServiceUrl = "http://localhost:804/historique/add";
    private final String historiqueServiceListUrl = "http://localhost:804/historique/list";


    public HistoriqueTranslationService(RestTemplate restTemplate) {
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

    public List<HistoriqueDto> getAllHistoriques() {
        try {
            ResponseEntity<List<HistoriqueDto>> response = restTemplate.exchange(historiqueServiceListUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<HistoriqueDto>>() {
                    }
            );
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de l'historique: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
