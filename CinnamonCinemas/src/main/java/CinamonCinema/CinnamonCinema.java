package CinamonCinema;

public class CinnamonCinema {

    private final int NUMBER_OF_ROWS = 3;
    private final int NUMBER_OF_SEATS_IN_ROW = 5;

    private String[][] screenSeats = new String[][]{{"-1","-1","-1","-1","-1","0"},
            {"-1","-1","-1","-1","-1","0"},{"-1","-1","-1","-1","-1","0"}};

    public int buyFilmTickets(String user, int numberOfTickets){
        int rowSeatsPurchased = -1;
        for(int row = 0; row < NUMBER_OF_ROWS; row++){
            int takenSeatsInRow = Integer.parseInt(screenSeats[row][NUMBER_OF_SEATS_IN_ROW]);
            if(NUMBER_OF_SEATS_IN_ROW - takenSeatsInRow >= numberOfTickets){
                int seatsToFill = takenSeatsInRow + numberOfTickets;
                for(int fillSeats = takenSeatsInRow; fillSeats < seatsToFill; fillSeats++){
                    screenSeats[row][fillSeats] = user;
                }
                screenSeats[row][NUMBER_OF_SEATS_IN_ROW] = Integer.toString(seatsToFill);
                rowSeatsPurchased = row;
                break;
            }
        }

        return rowSeatsPurchased;
    }

    public int seatsLeftInRow(int row){
        return NUMBER_OF_SEATS_IN_ROW - Integer.parseInt(screenSeats[row][NUMBER_OF_SEATS_IN_ROW]);
    }

}
