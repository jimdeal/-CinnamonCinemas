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
        CinnamonCinema cinema = new CinnamonCinema();
        Random rand = new Random();
        int randomSeats = rand.nextInt(4);
        assertTrue(cinema.buyFilmTickets("fred",randomSeats));
        assertEquals((5 - randomSeats),cinema.seatsLeftInRow(0));
    }

    @Test
    void twoUsersBuyFilmTicketsRandom() {
        int min = 2; // Minimum value of range
        int max = 3;

        CinnamonCinema cinema = new CinnamonCinema();
        Random rand = new Random();
        int randomSeats1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        assertTrue(cinema.buyFilmTickets("ted",randomSeats1));
        int seatsLeft1 = 5 - randomSeats1;
        assertEquals(seatsLeft1,cinema.seatsLeftInRow(0));

        int randomSeats2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        assertTrue(cinema.buyFilmTickets("bill",randomSeats2));

        int randomSeats3 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        assertTrue(cinema.buyFilmTickets("jon",randomSeats3));

        
        if((randomSeats1 + randomSeats2 + randomSeats3) <= 5){
            int seatsLeft2 = 5 - (randomSeats1 + randomSeats2 + randomSeats2);
            assertEquals(seatsLeft2,cinema.seatsLeftInRow(0));
        } else if((randomSeats1 + randomSeats2 + randomSeats3) <= 8) {
            if(randomSeats1 + randomSeats2 <= 5){
                int seatsLeft11 = 5 - (randomSeats1 + randomSeats2);
                int seatsLeft12 = 5 - randomSeats3;
                assertEquals(seatsLeft11,cinema.seatsLeftInRow(0));
                assertEquals(seatsLeft12,cinema.seatsLeftInRow(1));
            } else {
                int seatsLeft11 = 5 - (randomSeats1 + randomSeats3);
                int seatsLeft12 = 5 - randomSeats2;
                assertEquals(seatsLeft11, cinema.seatsLeftInRow(0));
                assertEquals(seatsLeft12, cinema.seatsLeftInRow(1));
            }

        } else {
            int seatsLeft11 = 5 - randomSeats1;
            int seatsLeft12 = 5 - randomSeats2;
            int seatsLeft13 = 5 - randomSeats3;
            assertEquals(seatsLeft11,cinema.seatsLeftInRow(0));
            assertEquals(seatsLeft12,cinema.seatsLeftInRow(1));
            assertEquals(seatsLeft13,cinema.seatsLeftInRow(2));
        }
    }
}