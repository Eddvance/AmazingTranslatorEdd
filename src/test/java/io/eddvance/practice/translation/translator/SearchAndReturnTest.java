package io.eddvance.practice.translation.translator;

import io.eddvance.practice.translation.data.FrenchTranslation;
import io.eddvance.practice.translation.data.GermanTranslation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;


class SearchAndReturnTest {

    private SearchAndReturn searchAndReturn;

    @BeforeEach
    void setUp() {
        searchAndReturn = new SearchAndReturn();
    }

    @Test
    void testGetTranslation_FrenchUn() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois"));
            String result = searchAndReturn.getTranslation(1, 1);
            assertEquals("un", result);
        }
    }

    @Test
    void testGetTranslation_FrenchCinq() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(5, 1);
            assertEquals("cinq", result);
        }
    }

    @Test
    void testGetTranslation_FrenchDix() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(10, 1);
            assertEquals("dix", result);
        }
    }

    @Test
    void testGetTranslation_FrenchQuinze() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(15, 1);
            assertEquals("quinze", result);
        }
    }

    @Test
    void testGetTranslation_FrenchVingt() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(20, 1);
            assertEquals("vingt", result);
        }
    }

    @Test
    void testGetTranslation_FrenchVingtCinq() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(25, 1);
            assertEquals("vingt-cinq", result);
        }
    }

    @Test
    void testGetTranslation_FrenchTrente() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt", "vingt-et-un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf", "trente"));
            String result = searchAndReturn.getTranslation(30, 1);
            assertEquals("trente", result);
        }
    }

    @Test
    void testGetTranslation_GermanEins() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(1, 2);
            assertEquals("eins", result);
        }
    }

    @Test
    void testGetTranslation_GermanFünf() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(5, 2);
            assertEquals("fünf", result);
        }
    }

    @Test
    void testGetTranslation_GermanZehn() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(10, 2);
            assertEquals("zehn", result);
        }
    }

    @Test
    void testGetTranslation_GermanFünfzehn() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(15, 2);
            assertEquals("fünfzehn", result);
        }
    }

    @Test
    void testGetTranslation_GermanZwanzig() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(20, 2);
            assertEquals("zwanzig", result);
        }
    }

    @Test
    void testGetTranslation_GermanFünfundzwanzig() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(25, 2);
            assertEquals("fünfundzwanzig", result);
        }
    }

    @Test
    void testGetTranslation_GermanDreißig() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig", "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"));
            String result = searchAndReturn.getTranslation(30, 2);
            assertEquals("dreißig", result);
        }
    }

    @Test
    void testGetTranslation_InvalidFrenchNumber() {
        try (MockedStatic<FrenchTranslation> frenchMock = mockStatic(FrenchTranslation.class)) {
            frenchMock.when(FrenchTranslation::getFrenchTranslations).thenReturn(List.of("un", "deux", "trois"));
            String result = searchAndReturn.getTranslation(5, 1);
            assertEquals(null, result);
        }
    }

    @Test
    void testGetTranslation_InvalidGermanNumber() {
        try (MockedStatic<GermanTranslation> germanMock = mockStatic(GermanTranslation.class)) {
            germanMock.when(GermanTranslation::getGermanTranslations).thenReturn(List.of("eins", "zwei", "drei"));
            String result = searchAndReturn.getTranslation(0, 2);
            assertEquals(null, result);
        }
    }

    @Test
    void testGetTranslation_InvalidLanguageSelection() {
        String result = searchAndReturn.getTranslation(2, 3);
        assertEquals(null, result);
    }
}