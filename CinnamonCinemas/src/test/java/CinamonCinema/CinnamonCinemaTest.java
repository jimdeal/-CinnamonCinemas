package CinamonCinema;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CinnamonCinemaTest {

    @Test
    void buyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("fred",2));
        assertEquals(3,cinema.seatsLeftInRow(0));
    }

    @Test
    void twoUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",2));
        assertTrue(cinema.buyFilmTickets("bill",2));
        assertEquals(1,cinema.seatsLeftInRow(0));
    }


    @Test
    void threeUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",2));
        assertTrue(cinema.buyFilmTickets("bill",2));
        assertTrue(cinema.buyFilmTickets("sue",2));
        assertEquals(1,cinema.seatsLeftInRow(0));
        assertEquals(3,cinema.seatsLeftInRow(1));

    }

    @Test
    void mixUsersBuyFilmTickets1() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",3));
        assertTrue(cinema.buyFilmTickets("bill",2));
        assertTrue(cinema.buyFilmTickets("sue",1));
        assertTrue(cinema.buyFilmTickets("jim",3));
        assertEquals(0,cinema.seatsLeftInRow(0));
        assertEquals(1,cinema.seatsLeftInRow(1));
    }

    @Test
    void mixUsersBuyFilmTickets2() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",3));
        assertTrue(cinema.buyFilmTickets("bill",2));
        assertTrue(cinema.buyFilmTickets("sue",1));
        assertTrue(cinema.buyFilmTickets("jim",3));
        assertTrue(cinema.buyFilmTickets("jon",3));
        assertFalse(cinema.buyFilmTickets("fred",3));
        assertEquals(0,cinema.seatsLeftInRow(0));
        assertEquals(1,cinema.seatsLeftInRow(1));
        assertEquals(2,cinema.seatsLeftInRow(2));
    }

    @Test
    void buyFilmTicketsRandom() {
    }

    @Test
    void twoUsersBuyFilmTicketsRandom() {
    }



}