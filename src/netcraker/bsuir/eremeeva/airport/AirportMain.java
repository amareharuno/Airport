package netcraker.bsuir.eremeeva.airport;

import netcraker.bsuir.eremeeva.airport.Exceptions.IllegalValueException;
import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.Airplanes.CargoAirplane;
import netcraker.bsuir.eremeeva.airport.entities.Airplanes.PassangerAirplane;
import netcraker.bsuir.eremeeva.airport.entities.Employees.Pilot;
import netcraker.bsuir.eremeeva.airport.enums.TypeOfService;
import netcraker.bsuir.eremeeva.airport.tools.AirlineManagementTool;
import netcraker.bsuir.eremeeva.airport.tools.AirplaneManagementTool;


public class AirportMain {
    public static void main(String[] args) {
        Airline airline = new Airline("Belavia", 1970, "BRU");
        try {
            CargoAirplane airplane1 = new CargoAirplane(
                    "Cargo1", 10, 600, 23, 23, 1000);
            AirplaneManagementTool.addEmployee(new Pilot("PilotName", "PilotLastName"), airplane1);

            CargoAirplane airplane2 = new CargoAirplane(
                    "Cargo2", 20, 500, 30, 100, 2000);
            CargoAirplane airplane3 = new CargoAirplane(
                    "Cargo3", 20, 500, 40, 10, 900);
            PassangerAirplane airplane4 = new PassangerAirplane(
                    "Pass4", 20, 500, 80, 100, 2000, TypeOfService.ALL);
            PassangerAirplane airplane5 = new PassangerAirplane(
                    "Pass5", 20, -1000, 50,10000, 2000, TypeOfService.ALL);

            AirlineManagementTool.addAirplane(airplane1, airline);
            AirlineManagementTool.addAirplane(airplane1, airline); // Проверка добавления одинаковых сотрудников
            AirlineManagementTool.addAirplane(airplane2, airline);
            AirlineManagementTool.addAirplane(airplane3, airline);
            AirlineManagementTool.addAirplane(airplane4, airline);
            AirlineManagementTool.addAirplane(airplane5, airline);

            System.out.println("+++++++++++ Airplane stuff +++++++++++");
            AirplaneManagementTool.printAirplaneStuff(airplane1);

            System.out.println("Airplanes list:");
            AirlineManagementTool.printAirplanesList(airline);

            AirlineManagementTool.sortAirplanesByFlightRange(airline.getAirplanes());
            System.out.println("\n----------- sorted: -------------");
            AirlineManagementTool.printAirplanesList(airline);

            System.out.println("\n======== found airplanes: =======");
            AirlineManagementTool.findAirplaneByFuelConsumption(0, 40, airline.getAirplanes());
        }
        catch (IllegalValueException e) {
            System.out.println("Ай-яй-яй, нужно задавать верные значения!" + "\n" +
                    "Причина ошибки: " + e.getMessage() + "\n");
        }
    }
}
