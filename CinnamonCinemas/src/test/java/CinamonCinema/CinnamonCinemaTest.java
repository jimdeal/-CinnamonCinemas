package CinamonCinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CinnamonCinemaTest {

    @Test
    void buyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertTrue(cinema.buyFilmTickets("fred",2));

    }
}