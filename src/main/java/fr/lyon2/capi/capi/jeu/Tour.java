package fr.lyon2.capi.capi.jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tour {

    // Les cartes autorisées (échelle de l'énoncé)
    public static final List<String> CARTES =
            List.of("0", "1/2", "1", "2", "3", "5", "8", "13", "20", "40", "100", "?", "café");

    private final List<Joueur> joueurs;
    private final List<String> votes = new ArrayList<>();   // votes dans l'ordre des joueurs

    public Tour(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    // Le joueur dont c'est le tour de voter (null si tout le monde a voté)
    public Joueur joueurQuiVote() {
        if (estTermine()) {
            return null;
        }
        return joueurs.get(votes.size());
    }

    // Enregistre la carte du joueur en cours
    public void voter(String carte) {
        if (estTermine()) {
            throw new IllegalStateException("Tous les joueurs ont déjà voté");
        }
        if (!CARTES.contains(carte)) {
            throw new IllegalArgumentException("Carte inconnue : " + carte);
        }
        votes.add(carte);
    }

    public boolean estTermine() {
        return votes.size() == joueurs.size();
    }

    // Révèle les votes, seulement quand tous les joueurs ont voté
    public List<String> reveler() {
        if (!estTermine()) {
            throw new IllegalStateException("Les votes ne sont révélés que lorsque tous les joueurs ont voté");
        }
        return Collections.unmodifiableList(votes);
    }
}