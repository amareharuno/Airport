package netcraker.bsuir.eremeeva.airport;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.Airplane;
import netcraker.bsuir.eremeeva.airport.tools.AirlineManagementTool;

import java.util.ArrayList;
import java.util.Collections;

public class AirportMain {
    public static void main(String[] args) {
        Airline airline = new Airline("Belavia", "BRU");

        System.out.println(airline.getAirplanesCount());
        ArrayList<Airplane> airplanes = airline.getAirplanes();
        AirlineManagementTool.sortAirplanesByFlightRange(airplanes);
    }
}
