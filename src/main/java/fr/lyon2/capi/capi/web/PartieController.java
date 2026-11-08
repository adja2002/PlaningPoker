package fr.lyon2.capi.capi.web;

import fr.lyon2.capi.capi.jeu.Backlog;
import fr.lyon2.capi.capi.jeu.ChargeurBacklog;
import fr.lyon2.capi.capi.jeu.Partie;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class PartieController {

    // Page d'accueil : saisie du nombre de joueurs
    @GetMapping("/")
    public String accueil() {
        return "accueil";
    }

    // Après le nombre de joueurs : affiche un champ de pseudo par joueur
    @PostMapping("/pseudos")
    public String pseudos(@RequestParam("nombreJoueurs") int nombreJoueurs, Model model) {
        model.addAttribute("nombreJoueurs", nombreJoueurs);
        return "pseudos";
    }

    // Après les pseudos : crée la partie et l'affiche
    @PostMapping("/partie")
    public String creerPartie(@RequestParam("pseudos") List<String> pseudos, HttpSession session, Model model) {
        Partie partie = new Partie(pseudos);
        session.setAttribute("partie", partie);
        model.addAttribute("partie", partie);
        return "partie";
    }

    // Après le choix du fichier : charge le backlog et affiche la première fonctionnalité
    @PostMapping("/backlog")
    public String chargerBacklog(@RequestParam("fichier") MultipartFile fichier, HttpSession session, Model model) {
        try {
            Backlog backlog = ChargeurBacklog.charger(fichier.getInputStream());
            session.setAttribute("backlog", backlog);
            model.addAttribute("backlog", backlog);
            model.addAttribute("fonctionnalite", backlog.premiereFonctionnalite());
            return "backlog";
        } catch (IllegalArgumentException | IOException e) {
            model.addAttribute("partie", session.getAttribute("partie"));
            model.addAttribute("erreur", e.getMessage());
            return "partie";
        }
    }
}