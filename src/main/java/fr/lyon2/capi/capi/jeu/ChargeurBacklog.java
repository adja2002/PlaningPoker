package fr.lyon2.capi.capi.jeu;

import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ChargeurBacklog {

    private static final ObjectMapper LECTEUR_JSON = new ObjectMapper();

    public static Backlog charger(InputStream fichier) {
        Backlog backlog;
        try {
            backlog = LECTEUR_JSON.readValue(fichier, Backlog.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Le fichier n'est pas un backlog JSON valide");
        }
        if (backlog == null || backlog.getFonctionnalites() == null || backlog.getFonctionnalites().isEmpty()) {
            throw new IllegalArgumentException("Le backlog ne contient aucune fonctionnalité");
        }
        return backlog;
    }
}