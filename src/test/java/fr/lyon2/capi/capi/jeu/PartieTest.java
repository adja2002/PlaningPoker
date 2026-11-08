package fr.lyon2.capi.capi.jeu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PartieTest {

    @Test
    void creerUnePartieAvecTroisJoueurs() {
        Partie partie = new Partie(List.of("Ana", "Bob", "Lea"));
        assertEquals(3, partie.getNombreJoueurs());
        assertEquals("Bob", partie.getJoueurs().get(1).pseudo());
    }

    @Test
    void refuserUnPseudoVide() {
        assertThrows(IllegalArgumentException.class, () -> new Partie(List.of("Ana", " ")));
    }
}
