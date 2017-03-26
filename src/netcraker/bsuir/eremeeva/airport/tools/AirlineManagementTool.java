package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.airplanes.Airplane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AirlineManagementTool {
    
    private static final Comparator<Airplane> compareByFlightRange
            = Comparator.comparingInt(Airplane::getFlightRange);

    private static ArrayList<Airline> airlines;

    public static ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public static void setAirlines(ArrayList<Airline> airlines) {
        AirlineManagementTool.airlines = airlines;
    }

    /**
     * Добавление авиакомпании
     * @param airline - авиакомпания
     */
    public static void addAirline(Airline airline) {
        ArrayList<Airline> airlines = getAirlines();
        airlines.add(airline);
        setAirlines(airlines);
    }

    /**
     * Удаление авиакомпании
     * @param airline - авиакомпания
     */
    public static void removeAirline(Airline airline) {
        ArrayList<Airline> airlines = getAirlines();
        
        if (airlines.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRLINES_REGISTERED);
        }
        else {
            for (Airline company : airlines) {
                if (company.equals(airline)) {
                    airlines.remove(airline);
                }
            }

            setAirlines(airlines);
        }
    }

    /**
     * Вывод всех авиакомпаний
     */
    public static void printAirlines() {
        ArrayList<Airline> airlines = getAirlines();

        if (airlines == null) {
            System.out.println(ConstantStrings.NO_AIRLINES_REGISTERED);
        }
        else {
            for (Airline airline : airlines) {
                System.out.println(airline);
            }
        }
    }

    /**
     * Добавление самолета в авиакомпанию
     * @param airplane - самолет
     * @param airline - целевая авиакомпания
     */
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

        airplane.setAirline(airline);
    }

    /**
     * Удаление самолета из авиакомпании
     * @param airplane - удаляемый самолет
     * @param airline - целевая авиакомпания
     */
    public static void removeAirplane(Airplane airplane, Airline airline) {
        ArrayList<Airplane> airplanes = airline.getAirplanes();

        if (airplanes.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
        }
        else {
            for (Airplane model : airplanes) {
                if (model.equals(airplane)) {
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

    /**
     * Сортировка самолетов по дальности полета
     * @param airplanes - список самолетов
     * @return - отсортированный по дальности полета список самолетов
     */
    public static List<Airplane> sortAirplanesByFlightRange(List<Airplane> airplanes){
        if (airplanes.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
            return null;
        }
        else {
            airplanes.sort(compareByFlightRange);
            return airplanes;
        }
    }

    /**
     * Выводит все самолеты авиакомпании
     * @param airline - авиакомпания
     */
    public static void printAirplanesList(Airline airline) {

        ArrayList<Airplane> airplanes = airline.getAirplanes();
        if (airplanes.isEmpty()){
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
        }
        else {
            for (Airplane airplane : airplanes) {
                System.out.println(airplane);
            }
        }
    }

    /**
     * Нахождение самолетов в заданном диапазоне потребления топлива.
     * @param fromValue - начальное значение диапазона
     * @param toValue - конечное значение
     * @param airline - авиакомпания, в которой выполняется поиск
     */
    public static void findAirplaneByFuelConsumption(int fromValue, int toValue, Airline airline){
        ArrayList<Airplane> airplanes = airline.getAirplanes();
        if (airplanes.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
        }
        else {
            int foundAirplanesCount = 0;
            for (Airplane airplaneModel : airplanes) {
                if (airplaneModel.getFuelConsumption() >= fromValue && airplaneModel.getFuelConsumption() <= toValue) {
                    System.out.println(airplaneModel);
                    foundAirplanesCount++;
                }
                if (foundAirplanesCount == 0) System.out.println(ConstantStrings.NO_AIRPLANES_IN_THIS_RANGE);
            }
        }
    }

}
