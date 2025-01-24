package io.eddvance.practice.execution;

import io.eddvance.practice.interaction.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ExecutTest {

    @Mock
    private InputReader inputReader;

    private Execut execut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        execut = new Execut();
    }

    @Test
    void testExecute() {}



}
