package io.eddvance.practice.execution;

import io.eddvance.practice.choices.choice_number.NumberToChoice;
import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.interaction.InputReader;
import io.eddvance.practice.translation.data.FrenchTranslation;
import io.eddvance.practice.translation.data.GermanTranslation;
import io.eddvance.practice.translation.translator.SearchAndReturn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

class ExecutTest {

    private Execut execut;

    @BeforeEach
    void setUp() throws Exception {
        // On instancie la classe normalement
        execut = new Execut();

        // -- Mock des dépendances --
        InputReader mockReader = mock(InputReader.class);
        FrenchTranslation mockFrenchTranslation = mock(FrenchTranslation.class);
        GermanTranslation mockGermanTranslation = mock(GermanTranslation.class);
        SearchAndReturn mockSearchAndReturn = mock(SearchAndReturn.class);
        TranslationToChoice mockTranslationToChoice = mock(TranslationToChoice.class);
        NumberToChoice mockNumberToChoice = mock(NumberToChoice.class);

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
        // On appelle init() pour ne pas oublier l'initialisation
        execut.init();

        // Lance la boucle
        execut.action();

        // Vérifications simples
        // On peut vérifier que frenchTranslation.frenchTranslation() a bien été appelé
        FrenchTranslation frenchTranslationMock = (FrenchTranslation) getFieldValue(execut, "frenchTranslation");
        verify(frenchTranslationMock, times(1)).frenchTranslation();

        // Vérifie qu'on a lu deux fois la ligne de commande (pour "y" puis "n")
        InputReader inputReaderMock = (InputReader) getFieldValue(execut, "inputReader");
        verify(inputReaderMock, times(2)).readLine();

        // Vérifie qu'on a demandé deux traductions
        SearchAndReturn searchAndReturnMock = (SearchAndReturn) getFieldValue(execut, "searchAndReturn");
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