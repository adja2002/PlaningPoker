
package fr.lyon2.capi.capi.jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoteurRegles {

    public enum Regle {
        STRICTE, MEDIANE
    }

    public record Resultat(boolean valide, String valeur) {}

    public static Resultat evaluer(List<String> votes, Regle regle, int numeroTour) {

        if (votes == null || votes.isEmpty()) {
            throw new IllegalArgumentException("Liste de votes vide");
        }

        // Les cartes speciales ne permettent pas de valider une estimation
        if (votes.contains("?") || votes.contains("café")) {
            return new Resultat(false, null);
        }

        // Verifier si tous les joueurs ont vote pareil
        boolean memeVote = true;

        for (String vote : votes) {
            if (!vote.equals(votes.get(0))) {
                memeVote = false;
                break;
            }
        }

        // Regle stricte ou premier tour de la regle mediane
        if (regle == Regle.STRICTE || numeroTour == 1) {
            if (memeVote) {
                return new Resultat(true, votes.get(0));
            }
            return new Resultat(false, null);
        }

        // Deuxieme tour avec la regle mediane
        List<Double> nombres = new ArrayList<>();

        for (String vote : votes) {
            if (vote.equals("1/2")) {
                nombres.add(0.5);
            } else {
                nombres.add(Double.parseDouble(vote));
            }
        }

        Collections.sort(nombres);

        // Pour un nombre pair, prendre la valeur centrale la plus haute
        int milieu = nombres.size() / 2;
        double mediane = nombres.get(milieu);

        if (mediane == 0.5) {
            return new Resultat(true, "1/2");
        }

        return new Resultat(true, String.valueOf((int) mediane));
    }
}
