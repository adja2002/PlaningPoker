package fr.lyon2.capi.capi.jeu;

import java.util.ArrayList;
import java.util.List;

public class Backlog {

    private String projet;
    private List<Fonctionnalite> fonctionnalites = new ArrayList<>();

    public String getProjet() { return projet; }
    public void setProjet(String projet) { this.projet = projet; }

    public List<Fonctionnalite> getFonctionnalites() { return fonctionnalites; }
    public void setFonctionnalites(List<Fonctionnalite> fonctionnalites) { this.fonctionnalites = fonctionnalites; }

    public Fonctionnalite premiereFonctionnalite() {
        return fonctionnalites.get(0);
    }
}