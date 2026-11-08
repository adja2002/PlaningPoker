package fr.lyon2.capi.capi.jeu;

public record Joueur(String pseudo) {

    public Joueur {
        if (pseudo == null || pseudo.isBlank()) {
            throw new IllegalArgumentException("Le pseudo ne peut pas être vide");
        }
    }
}
