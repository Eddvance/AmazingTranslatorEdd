package io.eddvance.practice.choices.choice_number;

import io.eddvance.practice.exceptions.NumberAskedCantNotBeEmpty;
import io.eddvance.practice.exceptions.NumberAskedMustBe1to30;
import io.eddvance.practice.exceptions.NumberAskedMustBeNumeric;
import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumberToChoiceTest {

    @Mock
    private InputReader mockInputReader;

    private NumberToChoice numberToChoice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        numberToChoice = new NumberToChoice(mockInputReader);
    }

    @Test
    void testNumberChoice_ValidInputOne() {
        when(mockInputReader.readLine()).thenReturn("1");
        assertEquals(1, numberToChoice.numberChoice());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputTen() {
        when(mockInputReader.readLine()).thenReturn("10");
        assertEquals(10, numberToChoice.numberChoice());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputTwenty() {
        when(mockInputReader.readLine()).thenReturn("20");
        assertEquals(20, numberToChoice.numberChoice());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputThirty() {
        when(mockInputReader.readLine()).thenReturn("30");
        assertEquals(30, numberToChoice.numberChoice());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_Empty() {
        when(mockInputReader.readLine()).thenReturn("", "15");
        assertEquals(15, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_EmptyTwo() {
        when(mockInputReader.readLine()).thenReturn("", "1");
        assertEquals(1, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_OutOfRange() {
        when(mockInputReader.readLine()).thenReturn("50", "15");
        assertEquals(15, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoiceEach_InvalidInput_twenty() {
        when(mockInputReader.readLine()).thenReturn("20");
        assertEquals(20, numberToChoice.numberChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_OutOfRangeBigger() {
        when(mockInputReader.readLine()).thenReturn("50000", "15");
        assertEquals(15, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_NotANumber() {
        when(mockInputReader.readLine()).thenReturn("abc", "15");
        assertEquals(15, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_NotANumberAtAll() {
        when(mockInputReader.readLine()).thenReturn(",./,!#@$%^&*()_", "15");
        assertEquals(15, numberToChoice.numberChoice());
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testConstructor_NullInputReaderAndScanner() throws NumberAskedMustBe1to30 {
        NumberToChoice numberToChoiceWithNulls = new NumberToChoice(null);
        assertNotNull(numberToChoiceWithNulls);
    }

    @Test
    void testConstructor_InitializesDefaultInputReader() throws NumberAskedMustBe1to30 {
        NumberToChoice numberToChoiceWithNulls = new NumberToChoice(null);
        assertNotNull(numberToChoiceWithNulls.getInputReader());
    }

    @Test
    void testNumberChoiceEach_NumberAskedMustBe1to30() {
        when(mockInputReader.readLine()).thenReturn("50");
        assertThrows(NumberAskedMustBe1to30.class, () -> numberToChoice.numberChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoiceEach_NumberAskedMustBeNumeric() {
        when(mockInputReader.readLine()).thenReturn("efwefewff");
        assertThrows(NumberAskedMustBeNumeric.class, () -> numberToChoice.numberChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoiceEach_NumberAskedCantNotBeEmpty() {
        when(mockInputReader.readLine()).thenReturn("");
        assertThrows(NumberAskedCantNotBeEmpty.class, () -> numberToChoice.numberChoiceEach());
        verify(mockInputReader, times(1)).readLine();
    }
}
