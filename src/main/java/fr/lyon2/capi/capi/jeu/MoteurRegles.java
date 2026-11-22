
package fr.lyon2.capi.capi.jeu;

import java.util.List;

public class MoteurRegles {

    public enum Regle {
        STRICTE, MEDIANE
    }

    public record Resultat(boolean valide, String valeur) {}

    public static Resultat evaluer(
            List<String> votes, Regle regle, int numeroTour) {

        throw new UnsupportedOperationException("Non implemente");
    }
}
