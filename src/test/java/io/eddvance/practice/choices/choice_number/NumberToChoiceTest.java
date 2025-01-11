package io.eddvance.practice.choices.choice_number;

import io.eddvance.practice.exceptions.NumberAskedMustBe1to30;
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
        int result = numberToChoice.numberChoice();
        assertEquals(1, result);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputTen() {
        when(mockInputReader.readLine()).thenReturn("10");
        int result = numberToChoice.numberChoice();
        assertEquals(10, result);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputTwenty() {
        when(mockInputReader.readLine()).thenReturn("20");
        int result = numberToChoice.numberChoice();
        assertEquals(20, result);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_ValidInputThirty() {
        when(mockInputReader.readLine()).thenReturn("30");
        int result = numberToChoice.numberChoice();
        assertEquals(30, result);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_Empty() {
        when(mockInputReader.readLine()).thenReturn("", "15");
        int result = numberToChoice.numberChoice();
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_EmptyTwo() {
        when(mockInputReader.readLine()).thenReturn("", "1");
        int result = numberToChoice.numberChoice();
        assertEquals(1, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_OutOfRange() {
        when(mockInputReader.readLine()).thenReturn("50", "15");
        assertThrows(NumberAskedMustBe1to30.class, numberToChoice::numberChoice);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoiceEach_InvalidInput_OutOfRange() {
        when(mockInputReader.readLine()).thenReturn("50");
        int result = numberToChoice.numberChoiceEach();
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_OutOfRangeBigger() {
        when(mockInputReader.readLine()).thenReturn("50000", "15");
        int result = numberToChoice.numberChoice();
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_NotANumber() {
        when(mockInputReader.readLine()).thenReturn("abc", "15");
        int result = numberToChoice.numberChoice();
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_NotANumberAtAll() {
        when(mockInputReader.readLine()).thenReturn(",./,!#@$%^&*()_", "15");
        int result = numberToChoice.numberChoice();
        assertEquals(15, result);
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
}
