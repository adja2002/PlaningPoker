package fr.lyon2.capi.capi.jeu;
import java.util.List;
public class Partie {
    private final List<Joueur> joueurs;

    public Partie(List<String> pseudos) {
        if (pseudos == null || pseudos.isEmpty()) {
            throw new IllegalArgumentException("Il faut au moins un joueur");
        }
        this.joueurs = pseudos.stream().map(Joueur::new).toList();
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNombreJoueurs() {
        return joueurs.size();
    }

}
