package fr.lyon2.capi.capi.web;

import fr.lyon2.capi.capi.jeu.Partie;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String pseudos(@RequestParam("nombreJoueurs") int nombreJoueurs, Model model) {   // ← modifiée
        model.addAttribute("nombreJoueurs", nombreJoueurs);
        return "pseudos";
    }

    // Après les pseudos : crée la partie et l'affiche
    @PostMapping("/partie")
    public String creerPartie(@RequestParam("pseudos") List<String> pseudos, HttpSession session, Model model) {   // ← modifiée
        Partie partie = new Partie(pseudos);
        session.setAttribute("partie", partie);   // on garde la partie pour l'US-07
        model.addAttribute("partie", partie);
        return "partie";
    }
}