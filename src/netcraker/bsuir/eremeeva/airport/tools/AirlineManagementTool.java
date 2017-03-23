package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.Airplanes.AbstractAirplane;

import java.util.ArrayList;
import java.util.Comparator;

public class AirlineManagementTool {

    private static final Comparator<AbstractAirplane> compareByFlightRange
            = Comparator.comparingInt(AbstractAirplane::getFlightRange);

    public static void addAirplane(AbstractAirplane airplane, Airline airline){
        ArrayList<AbstractAirplane> airplanes = airline.getAirplanes();

        int totalCapacity = airline.getTotalCapacity();
        int totalCarryingCapacity = airline.getTotalCarryingCapacity();

        airplanes.add(airplane);
        airline.setAirplanes(airplanes);

        totalCapacity += airplane.getCapacity();
        airline.setTotalCapacity(totalCapacity);

        totalCarryingCapacity += airplane.getCarryingCapacity();
        airline.setTotalCarryingCapacity(totalCarryingCapacity);
    }

    public static void removeAirplane(AbstractAirplane airplane, Airline airline) {
        ArrayList<AbstractAirplane> airplanes = airline.getAirplanes();

        if (airplanes.isEmpty()) {
            System.out.println("В компании и так нет ни одного самолета.");
        }
        else {
            for (AbstractAirplane model : airplanes) {
                if (model.getIdAirplane() == airplane.getIdAirplane()) {
                    int totalCapacity = airline.getTotalCapacity();
                    int totalCarryingCapacity = airline.getTotalCarryingCapacity();

                    totalCapacity -= airplane.getCapacity();
                    totalCarryingCapacity -= airplane.getCarryingCapacity();

                    airline.setTotalCapacity(totalCapacity);
                    airline.setTotalCarryingCapacity(totalCarryingCapacity);

                    airplanes.remove(airplane);
                }
            }

            airline.setAirplanes(airplanes);
        }
    }
    public static ArrayList<AbstractAirplane> sortAirplanesByFlightRange(ArrayList<AbstractAirplane> airplanes){
        if (airplanes.isEmpty()) {
            System.out.println("В авиакомпании нет ни одного самолета");
            return null;
        }
        else {
            airplanes.sort(compareByFlightRange);
            return airplanes;
        }
    }

    /**
     * выводит все самолеты авиакомпании
     */
    public static void printAirplanesList(Airline airline){
        ArrayList<AbstractAirplane> airplanes = airline.getAirplanes();
        for (AbstractAirplane airplane : airplanes) {
            System.out.println(airplane);
        }
    }

    public static void findAirplaneByFuelConsumption(int fromValue, int toValue, ArrayList<AbstractAirplane> airplanes){
        if (airplanes.isEmpty()) {
            System.out.println("В авиакомпании нет ни одного самолета");
        }
        else {
            int foundAirplanesCount = 0;
            for (AbstractAirplane airplaneModel : airplanes) {
                if (airplaneModel.getFuelConsumption() >= fromValue && airplaneModel.getFuelConsumption() <= toValue) {
                    System.out.println(airplaneModel);
                    foundAirplanesCount++;
                }
                if (foundAirplanesCount == 0) System.out.println("Нет ни одного самолета в заданном диапазоне.");
            }
        }
    }

}
