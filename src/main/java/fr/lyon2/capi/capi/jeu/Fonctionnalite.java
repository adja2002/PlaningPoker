package fr.lyon2.capi.capi.jeu;

public class Fonctionnalite {

    private String id;
    private String titre;

    public Fonctionnalite() {
    }

    public Fonctionnalite(String id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
}