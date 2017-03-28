package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.airplanes.Airplane;

import java.io.IOException;
import java.util.ArrayList;

public class MenuOperations {

    public static void openMenu() throws IOException {
        boolean isExit = false;

        System.out.println("Добро пожаловать в систему.");
        while (!isExit){
            showFirstScreen();

            switch (InputVerification.inputNumber()) {
                case 1: // Администратор
                    chooseAdminOperation();
                    break;
                case 2: // Клиент
                    chooseClientOperation();
                    break;
                case 0: // Выход из системы
                    System.out.println(ConstantStrings.IS_EXIT);
                    isExit = true;
                    break;
                default:
                    System.out.println(ConstantStrings.MENU_DELIMITER);
                    System.out.println(ConstantStrings.WRONG_INPUT);
            }
        }
    }

    private static void chooseAdminOperation() throws IOException {
        System.out.println("Вы работаете как администратор.\n");

        boolean isExit2 = false;

        while (!isExit2) {
            showSecondAdminScreen();

            switch (InputVerification.inputNumber()) {
                case 1: // Просмотреть список авиакомпаний
                    showAirlinesListScreen();
                    break;
                case 2: // Зарегистрировать авиакомпанию
                    AirlineManagementTool.registerAirline();
                    break;
                case 3: // Зарегестрировать самолет
                    AirplaneManagementTool.registerAirplane();
                    break;
                case 4: // Посчитать общую вместимость и грузоподъемность авиакомпании /Название авиакомпании/
                    showTotalCapacityAndCarryingCapacity();
                    break;
                case 5: // Сортировать самолеты авиакомпании /Название авиакомпании/ по дальности полета
                    showSortedByFlightRangeAirplanes();
                    break;
                case 6: // Найти в авиакомпании /Название авиакомпании/ самолет в заданном диапазоне значний потребления топлива
                    showAirplanesRange();
                    break;
                case 0: // Вернуться в предыдущее меню
                    isExit2 = true;
                    break;
                default:
                    System.out.println(ConstantStrings.MENU_DELIMITER);
                    System.out.println(ConstantStrings.WRONG_INPUT);
            }
        }
    }

    private static void chooseClientOperation() {
        System.out.println("Вы работаете как пользователь.\n");

        boolean isExit3 = false;

        while (!isExit3) {
            showSecondClientScreen();

            switch (InputVerification.inputNumber()) {
                case 1:
                    showAirlinesListScreen();
                    break;
                case 0:
                    // Вернуться в предыдущее меню
                    isExit3 = true;
                    break;
            }
        }
    }


    private static void showFirstScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        System.out.println(
                "Выберите пользователя:\n" +
                        "1. Администратор\n" +
                        "2. Клиент\n" +
                        "0. Выход"
        );
        System.out.println(ConstantStrings.MENU_DELIMITER);
    }

    private static void showSecondAdminScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        System.out.println(ConstantStrings.SELECT_OPERATION);
        System.out.println(
                "1. Просмотреть список авиакомпаний" + "\n" +
                        "2. Зарегистрировать авиакомпанию" + "\n" +
                        "3. Зарегестрировать самолет" + "\n" +
                        ConstantStrings.BACK
        );
        System.out.println(ConstantStrings.MENU_DELIMITER);
    }

    private static void showSecondClientScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        System.out.println(ConstantStrings.SELECT_OPERATION);
        System.out.println(
                "1. Просмотреть список авиакомпаний." + "\n" +
                        ConstantStrings.BACK
        );
        System.out.println(ConstantStrings.MENU_DELIMITER);
    }

    private static void showAirlinesListScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        AirlineManagementTool.printAirlines();
        System.out.println("\n" + ConstantStrings.BACK);
        System.out.println(ConstantStrings.MENU_DELIMITER);
        while (true){
            if (InputVerification.inputNumber() == 0) {
                break;
            }
            System.out.println("Для возврата в предыдущее меню введите 0.");
        }
    }

    private static void showTotalCapacityAndCarryingCapacity() throws IOException {
        Airline foundAirline = AirlineManagementTool.findAirlineByInputName();
        if (foundAirline != null) {
            System.out.println(ConstantStrings.MENU_DELIMITER +
                    "Общая вместимость = " + foundAirline.getTotalCapacity() +
                    "\nОбщая грузоподъемность = " + foundAirline.getTotalCarryingCapacity() +
                    ConstantStrings.MENU_DELIMITER);
        }
    }

    private static void showSortedByFlightRangeAirplanes() throws IOException {
        Airline foundAirline = AirlineManagementTool.findAirlineByInputName();
        if (foundAirline != null) {
            ArrayList<Airplane> airplanes = foundAirline.getAirplanes();
            AirlineManagementTool.sortAirplanesByFlightRange(airplanes);
            foundAirline.setAirplanes(airplanes);

            AirlineManagementTool.printAirplanesList(foundAirline);
        }
    }

    private static void showAirplanesRange() throws IOException {
        Airline foundAirline = AirlineManagementTool.findAirlineByInputName();
        if (foundAirline != null) {
            int from = InputVerification.inputNumber();
            int to = InputVerification.inputNumber();
            AirlineManagementTool.findAirplaneByFuelConsumption(from, to, foundAirline);
        }
    }
}
