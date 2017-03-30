package netcracker.bsuir.eremeeva.airport.tools.entitiesTools;

import netcracker.bsuir.eremeeva.airport.entities.airplanes.CargoAirplane;
import netcracker.bsuir.eremeeva.airport.entities.airplanes.Airplane;
import netcracker.bsuir.eremeeva.airport.entities.airplanes.PassengerAirplane;
import netcracker.bsuir.eremeeva.airport.entities.employees.Employee;
import netcracker.bsuir.eremeeva.airport.enums.TypeOfService;

import java.io.IOException;
import java.util.ArrayList;

public class AirplaneManagementTool {

    // Регистрация самолета (данные вводятся пользователем)
   public static void registerAirplane() throws IOException {
        boolean isExit = false;
        if (AirlineManagementTool.airlinesIsEmptyWithMessage()) {
            return;
        }
       System.out.println("Выберите тип самолета: \n" +
               "1. Грузовой" + "\n" +
               "2. Пассажирский" + "\n" +
               "0. Назад");
        while (!isExit) {
            switch (InputVerification.inputNumber()) {
                case 1: // Грузовой самолет
                    registerCargoAirplane();
                    isExit = true;
                    break;
                case 2: // Пассажирский самолет
                    registerPassengerAirplane();
                    isExit = true;
                    break;
                case 0: // Назад
                    isExit = true;
                    break;
                default:
                    System.out.println(ConstantStrings.MENU_DELIMITER);
                    System.out.println(ConstantStrings.WRONG_INPUT);
            }
        }
    }

    // Регистрация грузового самолета
    private static void registerCargoAirplane() throws IOException {

        String name = InputVerification.checkInputString("Введите название самолета: ");
        int capacity = InputVerification.checkInputInt("Введите вместимость самолета: ");
        int carryingCapacity = InputVerification.checkInputInt("Введите грузоподъемность: ");
        int fuelConsumption = InputVerification.checkInputInt("Введите потребление топлива: ");
        int flightRange = InputVerification.checkInputInt("Введите дальность полета: ");
        int maxSpeed = InputVerification.checkInputInt("Введите максимальную скорость: ");

        CargoAirplane cargoAirplane = new CargoAirplane(name, capacity, carryingCapacity,
                fuelConsumption, flightRange, maxSpeed);

        AirlineManagementTool.chooseAirlineAndAddAirplaneToIt(cargoAirplane);
        System.out.println("Самолет зарегистрирован\n" + ConstantStrings.MENU_DELIMITER);
    }

    // Регистрация пассажирского самолета
    private static void registerPassengerAirplane() throws IOException {

        String name = InputVerification.checkInputString("Введите название самолета: ");
        int capacity = InputVerification.checkInputInt("Введите вместимость самолета: ");
        int carryingCapacity = InputVerification.checkInputInt("Введите грузоподъемность: ");
        int fuelConsumption = InputVerification.checkInputInt("Введите потребление топлива: ");
        int flightRange = InputVerification.checkInputInt("Введите дальность полета: ");
        int maxSpeed = InputVerification.checkInputInt("Введите максимальную скорость: ");
        TypeOfService typeOfService = TypeOfService.ALL;

        boolean isExit = false;
        System.out.println("Выберите класс обслуживания:\n" +
                "1. Бизнесс\n" + "2. Эконом\n" + "3. Бизнесс + Эконом");

        while (!isExit) {
            switch (InputVerification.inputNumber()) {
                case 1:
                    typeOfService = TypeOfService.BUSINESS;
                    isExit = true;
                    break;
                case 2:
                    typeOfService = TypeOfService.ECO;
                    isExit = true;
                    break;
                case 3:
                    typeOfService = TypeOfService.ALL;
                    isExit = true;
                    break;
                default:
                    System.out.println(ConstantStrings.MENU_DELIMITER);
                    System.out.println(ConstantStrings.WRONG_INPUT);
            }
        }
        PassengerAirplane passengerAirplane = new PassengerAirplane(name, capacity, carryingCapacity,
                fuelConsumption, flightRange, maxSpeed, typeOfService);
        AirlineManagementTool.chooseAirlineAndAddAirplaneToIt(passengerAirplane);
        System.out.println("Самолет зарегистрирован\n" + ConstantStrings.MENU_DELIMITER);
    }

    // Добавление сотрудников в персонал самолета.
    public static void addEmployee(Employee employee, Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();

        for (Employee person : employees) {
            if (person.equals(employee)) {
                System.out.println(ConstantStrings.EMPLOYEE_ON_BOARD);
                return;
            }
        }
        employees.add(employee);
        employee.setAirplane(airplane);
        airplane.setAirplaneEmployeeList(employees);
    }

    // Удаление сотрудника из персонала самолета
    public static void removeEmployee(Employee employee, Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();

        if (employees.isEmpty()) {
            System.out.println(ConstantStrings.NO_EMPLOYEE_MESSAGE);
        }
        else {
            for (Employee person : employees) {
                if (person.getId() == employee.getId()) {
                    employees.remove(employee);
                }
            }

            airplane.setAirplaneEmployeeList(employees);
        }
    }

    // Вывод списка сотрудников самолета
    public static void printAirplaneStuff (Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
