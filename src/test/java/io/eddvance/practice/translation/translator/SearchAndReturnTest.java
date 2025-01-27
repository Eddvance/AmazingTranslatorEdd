package io.eddvance.practice.translation.translator;

import io.eddvance.practice.translatorAmazing.service.SearchAndReturn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class SearchAndReturnTest {
    @Mock
    //private InputReader mockInputReader;

    private SearchAndReturn searchAndReturn;

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
