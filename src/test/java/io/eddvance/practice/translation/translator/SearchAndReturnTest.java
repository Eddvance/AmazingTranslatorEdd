package io.eddvance.practice.translation.translator;

import io.eddvance.practice.translatorAmazing.service.TranslationSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class SearchAndReturnTest {
    @Mock
    //private InputReader mockInputReader;

    private TranslationSearchService searchAndReturn;

    @BeforeEach
    public void before() {
        //MockitoAnnotations.initMocks(this);
        //searchAndReturn = new SearchAndReturn(mockInputReader);
    }
    @Test
    void TestGetFrenchTranslation() {}

    @Test
    void TestGetGermanTranslation() {}

    @Test
    void TestGetTranslationReturn() {}
}
