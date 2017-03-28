package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.airplanes.Airplane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AirlineManagementTool {
    
    private static final Comparator<Airplane> compareByFlightRange
            = Comparator.comparingInt(Airplane::getFlightRange);

    private static ArrayList<Airline> airlines = new ArrayList<>();

    public static ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public static void setAirlines(ArrayList<Airline> airlines) {
        AirlineManagementTool.airlines = airlines;
    }

    // проверка на пустоту списка авиакомпаний
    public static boolean airlinesIsEmptyWithMessage() {
        if (AirlineManagementTool.getAirlines().isEmpty()) {
            System.out.println("Зарегистрируйте хотя бы одну авиакомпанию!");
            return true;
        }
        else {
            return false;
        }
    }

    public static Airline findAirlineByInputName() throws IOException {

        String airlineName = InputVerification.checkInputString("Введите имя авиакомпании: ");

        for (Airline airline : AirlineManagementTool.getAirlines()) {
            if (airline.getName().equals(airlineName)) {
                return airline;
            }
        }

        System.out.println("Такая авиакомпания не зарегистрированна.");
        return null;
    }

    // Добавление авиакомпании
    public static void addAirline(Airline airline) {
        ArrayList<Airline> airlines = getAirlines();
        airlines.add(airline);
        setAirlines(airlines);
    }

    public static void registerAirline() throws IOException {

        String name = InputVerification.checkInputString("Введите название авиакомпании: ");
        int foundationYear = InputVerification.checkInputYear();
        String codeICAO = InputVerification.checkInputString("Введите код ICAO: ");
        String address = InputVerification.checkInputString("Введите адрес: ");

        Airline airline = new Airline(name, foundationYear, codeICAO, address);
        AirlineManagementTool.addAirline(airline);
        System.out.println(ConstantStrings.MENU_DELIMITER + "\nАвиакомпания зарегистрированна\n" + airline);
    }

    // Удаление авиакомпании
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

    // Вывод всех авиакомпаний
    public static void printAirlines() {
        ArrayList<Airline> airlines = getAirlines();

        if (airlines.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRLINES_REGISTERED);
        }
        else {
            int i = 1;
            for (Airline airline : airlines) {
                System.out.println(i + ". " + airline);
                i++;
            }
        }
    }

    // Поиск авиакомании по ее имени и добавление в найденную авиакомпанию самолета
    public static void chooseAirlineAndAddAirplaneToIt(Airplane airplane) throws IOException {
        while (true) {
            String airlineName = InputVerification.checkInputString(
                    "Введите имя авиакомпании, которой принадлежит самолет: ");
            if (AirlineManagementTool.addAirplane(airplane, airlineName)) {
                System.out.println("Самолет успешно добавлен.");
                return;
            }
            else {
                System.out.println("Такой авиакомпании нет.");
            }
        }
    }

    // Добавление самолета в авиакомпанию
    public static boolean addAirplane(Airplane airplane, String airlineName){
        ArrayList<Airline> airlines = getAirlines();
        for (Airline airline : airlines) {
            if (airline.getName().equals(airlineName)) {
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

                return true;
            }
        }
        return false;
    }

    // Удаление самолета из авиакомпании
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

    // Сортировка самолетов по дальности полета
    public static List<Airplane> sortAirplanesByFlightRange(List<Airplane> airplanes){
        if (airplanes.isEmpty()) {
            return airplanes;
        }
        else {
            airplanes.sort(compareByFlightRange);
            return airplanes;
        }
    }

    // Выводит все самолеты авиакомпании
    public static void printAirplanesList(Airline airline) {

        ArrayList<Airplane> airplanes = airline.getAirplanes();
        if (airplanes.isEmpty()){
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
        }
        else {
            int i = 1;
            for (Airplane airplane : airplanes) {
                System.out.println(i + ". " + airplane);
                i++;
            }
        }
    }

    /* Нахождение самолетов в заданном диапазоне потребления топлива.
     * fromValue - начальное значение диапазона
     * toValue - конечное значение
     * airline - авиакомпания, в которой выполняется поиск */
    public static void findAirplaneByFuelConsumption(int fromValue, int toValue, Airline airline){
        ArrayList<Airplane> airplanes = airline.getAirplanes();
        if (airplanes.isEmpty()) {
            System.out.println(ConstantStrings.NO_AIRPLANE_MESSAGE);
        }
        else {
            int foundAirplanesCount = 0, i = 1;
            for (Airplane airplaneModel : airplanes) {
                if (airplaneModel.getFuelConsumption() >= fromValue && airplaneModel.getFuelConsumption() <= toValue) {
                    System.out.println(i + ". " + airplaneModel);
                    foundAirplanesCount++;
                    i++;
                }
                if (foundAirplanesCount == 0) System.out.println(ConstantStrings.NO_AIRPLANES_IN_THIS_RANGE);
            }
        }
    }

}
