package fr.lyon2.capi.capi.jeu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChargeurBacklogTest {

    private InputStream json(String contenu) {
        return new ByteArrayInputStream(contenu.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void chargerUnBacklogEtAfficherLaPremiereFonctionnalite() {
        String contenu = """
            {
              "projet": "Bibliothèque en ligne",
              "fonctionnalites": [
                { "id": "F1", "titre": "Rechercher un livre par titre" },
                { "id": "F2", "titre": "Emprunter un livre disponible" }
              ]
            }
            """;
        Backlog backlog = ChargeurBacklog.charger(json(contenu));

        assertEquals("Bibliothèque en ligne", backlog.getProjet());
        assertEquals(2, backlog.getFonctionnalites().size());
        assertEquals("Rechercher un livre par titre", backlog.premiereFonctionnalite().getTitre());
    }

    @Test
    void refuserUnJsonInvalide() {
        assertThrows(IllegalArgumentException.class, () -> ChargeurBacklog.charger(json("ceci n'est pas du JSON")));
    }

    @Test
    void refuserUnBacklogVide() {
        assertThrows(IllegalArgumentException.class,
                () -> ChargeurBacklog.charger(json("{ \"projet\": \"Vide\", \"fonctionnalites\": [] }")));
    }
}