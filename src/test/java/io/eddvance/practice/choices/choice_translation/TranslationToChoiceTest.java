package io.eddvance.practice.choices.choice_translation;

import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TranslationToChoiceTest {

@Mock
private InputReader mockInputReader;

private TranslationToChoice translationToChoice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        translationToChoice = new TranslationToChoice(mockInputReader);
    }

    @Test
    void testLanguageToChoice_ValidInputOne(){
        when(mockInputReader.readLine()).thenReturn("1");
        int result = translationToChoice.translationChoice();
        assert(result == 1);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testLanguageToChoice_ValidInputTwo(){
        when(mockInputReader.readLine()).thenReturn("2");
        int result = translationToChoice.translationChoice();
        assert(result == 2);
        verify(mockInputReader, times(1)).readLine();
    }
}
