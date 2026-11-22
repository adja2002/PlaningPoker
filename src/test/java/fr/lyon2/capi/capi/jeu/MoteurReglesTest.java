
package fr.lyon2.capi.capi.jeu;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoteurReglesTest {

    @Test
    void test_CA_04_2_stricte_unanimite() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5"),
                MoteurRegles.Regle.STRICTE, 1);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test_CA_03_1_stricte_desaccord() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "8"),
                MoteurRegles.Regle.STRICTE, 1);

        assertFalse(res.valide());
    }

    @Test
    void test_CA_03_1_mediane_premier_tour() {
        var res = MoteurRegles.evaluer(
                List.of("5", "8", "13", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 1);

        assertFalse(res.valide());
    }

    @Test
    void test_CA_03_2_mediane_unanimite() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 1);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test_CA_04_1_stricte_deuxieme_tour() {
        var res = MoteurRegles.evaluer(
                List.of("5", "3", "5"),
                MoteurRegles.Regle.STRICTE, 2);

        assertFalse(res.valide());
    }

    @Test
    void test_CA_04_3_stricte_unanimite() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5"),
                MoteurRegles.Regle.STRICTE, 2);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test_CA_05_1_mediane_deuxieme_tour() {
        var res = MoteurRegles.evaluer(
                List.of("5", "8", "13", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 2);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test_CA_05_2_mediane_paire() {
        var res = MoteurRegles.evaluer(
                List.of("3", "5", "8", "13"),
                MoteurRegles.Regle.MEDIANE, 2);

        assertTrue(res.valide());
        assertEquals("8", res.valeur());
    }
}
