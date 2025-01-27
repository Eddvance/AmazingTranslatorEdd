package io.eddvance.practice.execution;

import io.eddvance.practice.translatorAmazing.service.NumberChoiceService;
import io.eddvance.practice.translatorAmazing.service.LanguageChoiceService;
import io.eddvance.practice.translatorAmazing.util.InputReader;
import io.eddvance.practice.translatorAmazing.repository.FrenchTranslationRepository;
import io.eddvance.practice.translatorAmazing.repository.GermanTranslationRepository;
import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import io.eddvance.practice.translatorAmazing.controller.TranslatorConsoleController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

class ExecutTest {

    private TranslatorConsoleController execut;

    @BeforeEach
    void setUp() throws Exception {
        // On instancie la classe normalement
        execut = new TranslatorConsoleController();

        // -- Mock des dépendances --
        InputReader mockReader = mock(InputReader.class);
        FrenchTranslationRepository mockFrenchTranslation = mock(FrenchTranslationRepository.class);
        GermanTranslationRepository mockGermanTranslation = mock(GermanTranslationRepository.class);
        TranslationSearchService mockSearchAndReturn = mock(TranslationSearchService.class);
        LanguageChoiceService mockTranslationToChoice = mock(LanguageChoiceService.class);
        NumberChoiceService mockNumberToChoice = mock(NumberChoiceService.class);

        // -- Injection par réflexion --
        setFieldValue(execut, "inputReader", mockReader);
        setFieldValue(execut, "frenchTranslation", mockFrenchTranslation);
        setFieldValue(execut, "germanTranslation", mockGermanTranslation);
        setFieldValue(execut, "searchAndReturn", mockSearchAndReturn);
        setFieldValue(execut, "translationToChoice", mockTranslationToChoice);
        setFieldValue(execut, "numberToChoice", mockNumberToChoice);

        // -- Configuration des mocks --
        // Supposons que numberChoice() renvoie 5, puis 30
        when(mockNumberToChoice.numberChoice())
                .thenReturn(5)
                .thenReturn(30);

        // On veut d'abord le français (1), puis l'allemand (2)
        when(mockTranslationToChoice.translationToChoice())
                .thenReturn(1)
                .thenReturn(2);

        // Simule l'entrée utilisateur "y" pour relancer, puis "n" pour arrêter
        when(mockReader.readLine())
                .thenReturn("y")
                .thenReturn("n");

        // Pour la traduction, on simule une réponse
        when(mockSearchAndReturn.getTranslation(5, 1)).thenReturn("cinq");
        when(mockSearchAndReturn.getTranslation(30, 2)).thenReturn("dreißig");
    }

    @Test
    void testAction_WithMocks() {

        // Lance la boucle
        execut.action();

        // Vérifications simples
        // On peut vérifier que frenchTranslation.frenchTranslation() a bien été appelé
        FrenchTranslationRepository frenchTranslationMock = (FrenchTranslationRepository) getFieldValue(execut, "frenchTranslation");
        verify(frenchTranslationMock, times(1)).frenchTranslation;

        // Vérifie qu'on a lu deux fois la ligne de commande (pour "y" puis "n")
        InputReader inputReaderMock = (InputReader) getFieldValue(execut, "inputReader");
        verify(inputReaderMock, times(2)).readLine();

        // Vérifie qu'on a demandé deux traductions
        TranslationSearchService searchAndReturnMock = (TranslationSearchService) getFieldValue(execut, "searchAndReturn");
        verify(searchAndReturnMock).getTranslation(5, 1);
        verify(searchAndReturnMock).getTranslation(30, 2);
    }

    // Méthodes utilitaires pour injecter et lire par réflexion
    private void setFieldValue(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private Object getFieldValue(Object target, String fieldName) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}