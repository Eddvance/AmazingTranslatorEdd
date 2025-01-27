/*
package io.eddvance.practice.execution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class ExecutIntegrationTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // On peut initialiser ici si besoin
    }

    @AfterEach
    void tearDown() {
        // On rétablit l'entrée standard pour ne pas perturber les autres tests
        System.setIn(originalIn);
    }

    @Test
    void testActionIntegration() {
        /*
         * Entrée simulée :
         *  - "5" : Nombre à traduire (première itération).
         *  - "1" : Langue sélectionnée (Français).
         *  - "y" : Relancer la traduction.
         *  - "30" : Nombre à traduire (deuxième itération).
         *  - "2" : Langue sélectionnée (Allemand).
         *  - "n" : Terminer.

        String simulatedInput = String.join("\n",
                "5",  // Premier nombre
                "1",  // Français
                "y",  // Relancer
                "30", // Deuxième nombre
                "2",  // Allemand
                "n"   // Terminer
        ) + "\n";

        // Redirige System.in
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);

        // Exécute le programme
        Execut execut = new Execut();
        execut.init();
        execut.action();

        // Test réussi si aucune exception n'est levée
    }

}
*/