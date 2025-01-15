package io.eddvance.practice.choices.choice_translation;

import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.exceptions.NumberMustBe1Or2;
import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class TranslationToChoiceTest {

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
        int result = translationToChoice.translationChoiceEach();
        assert(result == 1);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testLanguageToChoice_ValidInputTwo(){
        when(mockInputReader.readLine()).thenReturn("2");
        int result = translationToChoice.translationChoiceEach();
        assert(result == 2);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testLanguageToChoice_Empty(){
        when(mockInputReader.readLine()).thenReturn("", "1");
        int result = translationToChoice.translationChoiceEach();
        assert(result == 1);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testLanguageToChoice_EmptyTwo(){
        when(mockInputReader.readLine()).thenReturn("", "2");
        int result = translationToChoice.translationChoiceEach();
        assert(result == 2);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testLanguageToChoice_NotANumberAtAll(){
        when(mockInputReader.readLine()).thenReturn(",./,!#@$%^&*()_", "1");
        int result = translationToChoice.translationChoiceEach();
        assert(result == 1);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testConstructor_NullInputReader () throws NumberMustBe1Or2{
        TranslationToChoice translationToChoiceWithNulls = new TranslationToChoice(null);
        assertNotNull (translationToChoiceWithNulls);
    }

    @Test
    void testConstructor_InitializesDefaultInputReader() throws NumberMustBe1Or2{
        TranslationToChoice translationToChoiceWithNulls = new TranslationToChoice(null);
        assertNotNull(translationToChoiceWithNulls.getInputReader());
    }
}