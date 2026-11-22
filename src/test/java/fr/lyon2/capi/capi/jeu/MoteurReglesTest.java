
package fr.lyon2.capi.capi.jeu;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoteurReglesTest {

    @Test
    void test1() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5"),
                MoteurRegles.Regle.STRICTE, 1);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test2() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "8"),
                MoteurRegles.Regle.STRICTE, 1);

        assertFalse(res.valide());
    }

    @Test
    void test3() {
        var res = MoteurRegles.evaluer(
                List.of("5", "8", "13", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 1);

        assertFalse(res.valide());
    }

    @Test
    void test4() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 1);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test5() {
        var res = MoteurRegles.evaluer(
                List.of("5", "3", "5"),
                MoteurRegles.Regle.STRICTE, 2);

        assertFalse(res.valide());
    }

    @Test
    void test6() {
        var res = MoteurRegles.evaluer(
                List.of("5", "5", "5"),
                MoteurRegles.Regle.STRICTE, 2);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test7() {
        var res = MoteurRegles.evaluer(
                List.of("5", "8", "13", "5", "5"),
                MoteurRegles.Regle.MEDIANE, 2);

        assertTrue(res.valide());
        assertEquals("5", res.valeur());
    }

    @Test
    void test8() {
        var res = MoteurRegles.evaluer(
                List.of("3", "5", "8", "13"),
                MoteurRegles.Regle.MEDIANE, 2);

        assertTrue(res.valide());
        assertEquals("8", res.valeur());
    }
}
