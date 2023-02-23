package CinamonCinema;

public class CinnamonCinema {

    private final int NUMBER_OF_ROWS = 3;
    private final int NUMBER_OF_SEATS_IN_ROW = 5;

    private String[][] screenSeats = new String[][]{{"-1","-1","-1","-1","-1","0"},
            {"-1","-1","-1","-1","-1","0"},{"-1","-1","-1","-1","-1","0"}};

    public boolean buyFilmTickets(String user, int numberOfTickets){
        boolean purchaseSuccess = false;
        for(int row = 0; row < NUMBER_OF_ROWS; row++){
            int takenSeatsInRow = Integer.parseInt(screenSeats[row][5]);
            if(NUMBER_OF_SEATS_IN_ROW - takenSeatsInRow >= numberOfTickets){
                int seatsToFill = takenSeatsInRow + numberOfTickets;
                for(int fillSeats = takenSeatsInRow; fillSeats < seatsToFill; fillSeats++){
                    screenSeats[row][fillSeats] = user;
                }
                screenSeats[row][5] = Integer.toString(seatsToFill);
                purchaseSuccess = true;
                break;
            }
        }

        return purchaseSuccess;
    }

    public int seatsLeftInRow(int row){
        return NUMBER_OF_SEATS_IN_ROW - Integer.parseInt(screenSeats[row][5]);
    }

}
