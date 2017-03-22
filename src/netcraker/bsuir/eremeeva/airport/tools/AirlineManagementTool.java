package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.Airplane;

import java.util.ArrayList;
import java.util.Comparator;

public class AirlineManagementTool {

    final private static Comparator<Airplane> compareByFlightRange = new Comparator<Airplane>() {
        @Override
        public int compare(Airplane o1, Airplane o2) {
            return o1.getFlightRange() - o2.getFlightRange();
        }
    };

    public static void addAirplane(Airplane airplane, Airline airline){
        ArrayList<Airplane> airplanes = airline.getAirplanes();
        int totalCapacity = airline.getTotalCapacity();
        int totalCarryingCapacity = airline.getTotalCarryingCapacity();

        airplanes.add(airplane);
        airline.setAirplanes(airplanes);

        totalCapacity += airplane.getCapacity();
        airline.setTotalCapacity(totalCapacity);

        totalCarryingCapacity += airplane.getCarryingCapacity();
        airline.setTotalCarryingCapacity(totalCarryingCapacity);
    }

    public static void removeAirplane(Airplane airplane, Airline airline) {
        ArrayList<Airplane> airplanes = airline.getAirplanes();

        if (airplanes.isEmpty()) {
            System.out.println("В компании и так нет ни одного самолета.");
        }
        else {
            for (Airplane model : airplanes) {
                if (model.getId() == airplane.getId()) {
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
    public static ArrayList<Airplane> sortAirplanesByFlightRange(ArrayList<Airplane> airplanes){
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
        ArrayList<Airplane> airplanes = airline.getAirplanes();
        for (Airplane airplane : airplanes) {
            System.out.println(airplane); // переопределить toString
        }
    }

    public void findAirplaneByFuelConsumption(int fromValue, int toValue, ArrayList<Airplane> airplanes){
        if (airplanes.isEmpty()) {
            System.out.println("В авиакомпании нет ни одного самолета");
            return;
        }
        else {
            short foundAirplanesCount = 0;
            for (Airplane airplaneModel : airplanes) {
                if (airplaneModel.getFuelConsumption() >= fromValue && airplaneModel.getFuelConsumption() <= toValue) {
                    System.out.println(airplaneModel);
                    foundAirplanesCount++;
                }
                if (foundAirplanesCount == 0) System.out.println("Нет ни одного самолета в заданном диапазоне.");
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
