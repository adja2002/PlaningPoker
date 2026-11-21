package fr.lyon2.capi.capi.web;

import fr.lyon2.capi.capi.jeu.Backlog;
import fr.lyon2.capi.capi.jeu.ChargeurBacklog;
import fr.lyon2.capi.capi.jeu.Partie;
import fr.lyon2.capi.capi.jeu.Tour;
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
            session.removeAttribute("tour");   // un nouveau backlog démarre un nouveau tour
            model.addAttribute("backlog", backlog);
            model.addAttribute("fonctionnalite", backlog.premiereFonctionnalite());
            return "backlog";
        } catch (IllegalArgumentException | IOException e) {
            model.addAttribute("partie", session.getAttribute("partie"));
            model.addAttribute("erreur", e.getMessage());
            return "partie";
        }
    }

    // Page de vote : affiche seulement le joueur dont c'est le tour
    @GetMapping("/vote")
    public String vote(HttpSession session, Model model) {
        Tour tour = (Tour) session.getAttribute("tour");
        if (tour == null) {
            Partie partie = (Partie) session.getAttribute("partie");
            tour = new Tour(partie.getJoueurs());
            session.setAttribute("tour", tour);
        }
        if (tour.estTermine()) {
            return "redirect:/revelation";
        }
        Backlog backlog = (Backlog) session.getAttribute("backlog");
        model.addAttribute("joueur", tour.joueurQuiVote());
        model.addAttribute("cartes", Tour.CARTES);
        model.addAttribute("fonctionnalite", backlog.premiereFonctionnalite());
        return "vote";
    }

    // Enregistre la carte, puis passe au joueur suivant ou à la révélation
    @PostMapping("/vote")
    public String voter(@RequestParam("carte") String carte, HttpSession session) {
        Tour tour = (Tour) session.getAttribute("tour");
        tour.voter(carte);
        return tour.estTermine() ? "redirect:/revelation" : "redirect:/vote";
    }

    // Révèle tous les votes en même temps
    @GetMapping("/revelation")
    public String revelation(HttpSession session, Model model) {
        Tour tour = (Tour) session.getAttribute("tour");
        Partie partie = (Partie) session.getAttribute("partie");
        Backlog backlog = (Backlog) session.getAttribute("backlog");
        model.addAttribute("joueurs", partie.getJoueurs());
        model.addAttribute("votes", tour.reveler());
        model.addAttribute("fonctionnalite", backlog.premiereFonctionnalite());
        return "revelation";
    }

    // Recommence un tour de vote sur la même fonctionnalité
    @PostMapping("/nouveau-tour")
    public String nouveauTour(HttpSession session) {
        session.removeAttribute("tour");
        return "redirect:/vote";
    }
}