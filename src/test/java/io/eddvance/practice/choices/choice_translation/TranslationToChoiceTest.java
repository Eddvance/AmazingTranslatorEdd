package io.eddvance.practice.choices.choice_translation;

import io.eddvance.practice.choices.choices_translation.TranslationToChoice;
import io.eddvance.practice.exceptions.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.exceptions.NumberAskedMustBeNumeric;
import io.eddvance.practice.exceptions.NumberMustBe1Or2;
import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void testTranslationChoiceEach_ValidInputOne(){
        when(mockInputReader.readLine()).thenReturn("1");
        assert(translationToChoice.translationChoiceEach() == 1);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testTranslationChoiceEach_ValidInputTwo(){
        when(mockInputReader.readLine()).thenReturn("2");
        assert(translationToChoice.translationChoiceEach() == 2);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testTranslationChoice_Empty(){
        when(mockInputReader.readLine()).thenReturn("", "1");
        assert(translationToChoice.translationToChoice() == 1);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testTranslationChoice_EmptyTwo(){
        when(mockInputReader.readLine()).thenReturn("", "2");
        assert(translationToChoice.translationToChoice() == 2);
        verify(mockInputReader, times(2)).readLine();
    }
    @Test
    void testTranslationChoiceEach_NumberAskedMustBe1to30() {
        when(mockInputReader.readLine()).thenReturn("50");
        assertThrows(NumberMustBe1Or2.class, () -> translationToChoice.translationChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testTranslationChoiceEach_NumberAskedMustBeNumeric() {
        when(mockInputReader.readLine()).thenReturn("efwefewff");
        assertThrows(NumberAskedMustBeNumeric.class, () -> translationToChoice.translationChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testTranslationChoiceEach_NumberAskedCantNotBeEmpty() {
        when(mockInputReader.readLine()).thenReturn("");
        assertThrows(NumberAskedCantNotBeEmpty.class, () -> translationToChoice.translationChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testTranslationChoice_NotANumberAtAll(){
        when(mockInputReader.readLine()).thenReturn(",./,!#@$%^&*()_", "1");
        assert(translationToChoice.translationToChoice() == 1);
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