package netcraker.bsuir.eremeeva.airport;

import netcraker.bsuir.eremeeva.airport.tools.MenuOperations;

public class AirportMain {
    public static void main(String[] args) {
        try {
            //InitializationManager.initialize();
            MenuOperations.openMenu();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
