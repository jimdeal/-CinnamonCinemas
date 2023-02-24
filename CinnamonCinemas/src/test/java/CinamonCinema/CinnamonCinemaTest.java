package CinamonCinema;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CinnamonCinemaTest {

    @Test
    void buyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertEquals(0,cinema.buyFilmTickets("fred",2));
        assertEquals(3,cinema.seatsLeftInRow(0));
    }

    @Test
    void twoUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertEquals(0,cinema.buyFilmTickets("ted",2));
        assertEquals(0,cinema.buyFilmTickets("bill",2));
        assertEquals(1,cinema.seatsLeftInRow(0));
    }


    @Test
    void threeUsersBuyFilmTickets() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertEquals(0,cinema.buyFilmTickets("ted",2));
        assertEquals(0,cinema.buyFilmTickets("bill",2));
        assertEquals(1,cinema.buyFilmTickets("sue",2));
        assertEquals(1,cinema.seatsLeftInRow(0));
        assertEquals(3,cinema.seatsLeftInRow(1));

    }

    @Test
    void mixUsersBuyFilmTickets1() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertEquals(0,cinema.buyFilmTickets("ted",3));
        assertEquals(0,cinema.buyFilmTickets("bill",2));
        assertEquals(1,cinema.buyFilmTickets("sue",1));
        assertEquals(1,cinema.buyFilmTickets("jim",3));
        assertEquals(0,cinema.seatsLeftInRow(0));
        assertEquals(1,cinema.seatsLeftInRow(1));
    }

    @Test
    void mixUsersBuyFilmTickets2() {
        CinnamonCinema cinema = new CinnamonCinema();
        assertEquals(0,cinema.buyFilmTickets("ted",3));
        assertEquals(0,cinema.buyFilmTickets("bill",2));
        assertEquals(1,cinema.buyFilmTickets("sue",1));
        assertEquals(1,cinema.buyFilmTickets("jim",3));
        assertEquals(2,cinema.buyFilmTickets("jon",3));
        assertEquals(-1,cinema.buyFilmTickets("fred",3));
        assertEquals(0,cinema.seatsLeftInRow(0));
        assertEquals(1,cinema.seatsLeftInRow(1));
        assertEquals(2,cinema.seatsLeftInRow(2));
    }

    @Test
    void buyFilmTicketsRandom() {
        CinnamonCinema cinema = new CinnamonCinema();
        Random rand = new Random();
        int randomSeats = rand.nextInt(4);
        assertEquals(0,cinema.buyFilmTickets("fred",randomSeats));
        assertEquals((5 - randomSeats),cinema.seatsLeftInRow(0));
    }

    @Test
    void threeUsersBuyFilmTicketsRandom() {
        int min = 2; // Minimum value of range
        int max = 3;

        CinnamonCinema cinema = new CinnamonCinema();
        Random rand = new Random();
        int randomSeats1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        assertEquals(0,cinema.buyFilmTickets("ted",randomSeats1));
        int seatsLeft1 = 5 - randomSeats1;
        assertEquals(seatsLeft1,cinema.seatsLeftInRow(0));

        int randomSeats2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int currentTotal = randomSeats2 + randomSeats1;
        int rowSeatsIn = cinema.buyFilmTickets("bill",randomSeats2);

        if(currentTotal<=5){
            assertEquals((5-currentTotal),cinema.seatsLeftInRow(0));
        } else {
            assertEquals(5-randomSeats1,cinema.seatsLeftInRow(0));
            assertEquals(5-randomSeats2,cinema.seatsLeftInRow(rowSeatsIn));
        }

        int randomSeats3 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int currentTotal1 = randomSeats3 + randomSeats2 + randomSeats1;
        assertFalse(cinema.buyFilmTickets("jon",randomSeats3) == -1);

        if(currentTotal1<=5){
            assertEquals((5-currentTotal1),cinema.seatsLeftInRow(0));
        } else if (currentTotal1<=8){
            if((randomSeats1 == 3) && (randomSeats2 == 3)){
                // row 0 = randomSeats1 + randomSeats3
                int current0SeatsTotal = randomSeats1 + randomSeats3;
                assertEquals((5-current0SeatsTotal),cinema.seatsLeftInRow(0));
                assertEquals((5-randomSeats2), cinema.seatsLeftInRow(1));
            } else {
                // row 0 = randomSeats1 + randomSeats2
                int current0SeatsTotal = randomSeats1 + randomSeats2;
                assertEquals((5-current0SeatsTotal),cinema.seatsLeftInRow(0));
                assertEquals((5-randomSeats3), cinema.seatsLeftInRow(1));

            }
        }else { //currentTotal1>8
            int seatsLeft11 = 5 - randomSeats1;
            int seatsLeft12 = 5 - randomSeats2;
            int seatsLeft13 = 5 - randomSeats3;
            assertEquals(seatsLeft11,cinema.seatsLeftInRow(0));
            assertEquals(seatsLeft12,cinema.seatsLeftInRow(1));
            assertEquals(seatsLeft13,cinema.seatsLeftInRow(2));
        }
    }
    @Test
    void fourUsersBuyFilmTicketsRandom() {
        int min = 1; // Minimum value of range
        int max = 3;

        CinnamonCinema cinema = new CinnamonCinema();
        Random rand = new Random();
        int randomSeats1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int runningTotal = randomSeats1;
        int rowSeatsIn = cinema.buyFilmTickets("ted",randomSeats1);
        assertEquals(0,rowSeatsIn);
        int seatsLeft1 = 5 - randomSeats1;
        assertEquals(seatsLeft1,cinema.seatsLeftInRow(rowSeatsIn));

        int randomSeats2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        runningTotal = randomSeats2 + randomSeats1;
        int rowSeatsIn1 = cinema.buyFilmTickets("bill",randomSeats2);

        if(runningTotal<=5){
            assertEquals((5-runningTotal),cinema.seatsLeftInRow(0));
        } else {
            assertEquals(5-randomSeats1,cinema.seatsLeftInRow(0));
            assertEquals(5-randomSeats2,cinema.seatsLeftInRow(rowSeatsIn1));
        }

        int randomSeats3 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        runningTotal = randomSeats3 + randomSeats2 + randomSeats1;
        int rowSeatsIn2 = cinema.buyFilmTickets("jon",randomSeats3);
        assertFalse(rowSeatsIn2 == -1);

        if(runningTotal<=5){
            assertEquals((5-runningTotal),cinema.seatsLeftInRow(0));
        } else if (runningTotal<=8){
            if((randomSeats1 == 3) && (randomSeats2 == 3)){
                // row 0 = randomSeats1 + randomSeats3
                int current0SeatsTotal = randomSeats1 + randomSeats3;
                assertEquals((5-current0SeatsTotal),cinema.seatsLeftInRow(0));
                assertEquals((5-randomSeats2), cinema.seatsLeftInRow(1));
            } else {
                // row 0 = randomSeats1 + randomSeats2
                int current0SeatsTotal = randomSeats1 + randomSeats2;
                assertEquals((5-current0SeatsTotal),cinema.seatsLeftInRow(0));
                assertEquals((5-randomSeats3), cinema.seatsLeftInRow(1));
            }
        }else {
            int seatsLeft11 = 5 - randomSeats1;
            int seatsLeft12 = 5 - randomSeats2;
            int seatsLeft13 = 5 - randomSeats3;
            assertEquals(seatsLeft11,cinema.seatsLeftInRow(0));
            assertEquals(seatsLeft12,cinema.seatsLeftInRow(1));
            assertEquals(seatsLeft13,cinema.seatsLeftInRow(2));
        }

        int randomSeats4 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        runningTotal = randomSeats4 + randomSeats3 + randomSeats2 + randomSeats1;
        int lastPurchaseAllowed = cinema.buyFilmTickets("jan",randomSeats4);

        if(lastPurchaseAllowed < 0){
            assertEquals(randomSeats4, 3);
        } else if (runningTotal<=5){ // within 1 row : 4 buys - 2 + 1 + 1 + 1
            assertEquals((5-runningTotal),cinema.seatsLeftInRow(0));
        } else if (runningTotal<=10){ // max within 2 rows : 4 buys - 3 + 3 + 2 + 2
            int row0 = 5-cinema.seatsLeftInRow(0);
            int row1 = 5-cinema.seatsLeftInRow(1);
            assertTrue((row0+row1) >= 4);
            assertTrue((row0+row1) <= 10);
        } else{ // max within 2 rows : 4 buys - 3 + 3 + 3 + 2
            int row0 = 5-cinema.seatsLeftInRow(0);
            int row1 = 5-cinema.seatsLeftInRow(1);
            int row2 = 5-cinema.seatsLeftInRow(2);
            assertTrue((row0+row1+row2) >= 4);
            assertTrue((row0+row1) <= 11);
        }

    }

}