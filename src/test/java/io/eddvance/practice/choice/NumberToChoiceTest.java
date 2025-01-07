package io.eddvance.practice.choice;

import io.eddvance.practice.exceptions.NumberAskedMustBe1to30;
import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Scanner;

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
    void testNumberChoice_ValidInput() throws Exception {
        // Arrange
        when(mockInputReader.readLine()).thenReturn("15");

        // Act
        int result = numberToChoice.numberChoice();

        // Assert
        assertEquals(15, result);
        verify(mockInputReader, times(1)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_Empty() throws Exception {
        // Arrange
        when(mockInputReader.readLine()).thenReturn("", "15");

        // Act
        int result = numberToChoice.numberChoice();

        // Assert
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_OutOfRange() throws Exception {
        // Arrange
        when(mockInputReader.readLine()).thenReturn("50", "15");

        // Act
        int result = numberToChoice.numberChoice();

        // Assert
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testNumberChoice_InvalidInput_NotANumber() throws Exception {
        // Arrange
        when(mockInputReader.readLine()).thenReturn("abc", "15");

        // Act
        int result = numberToChoice.numberChoice();

        // Assert
        assertEquals(15, result);
        verify(mockInputReader, times(2)).readLine();
    }

    @Test
    void testConstructor_NullInputReaderAndScanner() throws NumberAskedMustBe1to30 {
        // Act
        NumberToChoice numberToChoiceWithNulls = new NumberToChoice(null);

        // Assert
        assertNotNull(numberToChoiceWithNulls);
    }
}
