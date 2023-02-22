package CinamonCinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CinnamonCinemaTest {

    @Test
    void buyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("fred",2));
    }

    @Test
    void twoUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",2));
        assertTrue(cinema.buyFilmTickets("bill",2));
    }


    @Test
    void threeUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("ted",2));
        assertTrue(cinema.buyFilmTickets("bill",2));
        assertTrue(cinema.buyFilmTickets("sue",2));
    }

}