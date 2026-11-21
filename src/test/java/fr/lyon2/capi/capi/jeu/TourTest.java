package fr.lyon2.capi.capi.jeu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TourTest {

    private Tour tourAvecAnaEtBob() {
        return new Tour(List.of(new Joueur("Ana"), new Joueur("Bob")));
    }

    @Test
    void lesJoueursVotentChacunLeurTour() {
        Tour tour = tourAvecAnaEtBob();
        tour.voter("5");
        assertEquals("Bob", tour.joueurQuiVote().pseudo());
    }

    @Test
    void lesVotesRestentCachesTantQueToutLeMondeNaPasVote() {
        Tour tour = tourAvecAnaEtBob();
        tour.voter("5");
        assertThrows(IllegalStateException.class, tour::reveler);
    }

    @Test
    void revelerLesVotesQuandToutLeMondeAVote() {
        Tour tour = tourAvecAnaEtBob();
        tour.voter("5");
        tour.voter("8");
        assertTrue(tour.estTermine());
        assertEquals(List.of("5", "8"), tour.reveler());
    }

    @Test
    void refuserUneCarteInconnue() {
        Tour tour = tourAvecAnaEtBob();
        assertThrows(IllegalArgumentException.class, () -> tour.voter("7"));
    }
}