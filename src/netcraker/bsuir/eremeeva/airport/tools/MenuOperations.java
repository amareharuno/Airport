package netcraker.bsuir.eremeeva.airport.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class MenuOperations {

    public static void menu() {
        boolean isExit = false;

        System.out.println("Добро пожаловать в систему.");
        while (!isExit){
            showFirstScreen();

            switch (inputNumber()) {
                case 1:
                    // Администратор
                    System.out.println("Вы работаете как администратор.\n");

                    boolean isExit2 = false;

                    while (!isExit2) {
                        showSecondAdminScreen();

                        switch (inputNumber()) {
                            case 1:
                                // Просмотреть список авиакомпаний
                                showAirlinesListScreen();
                                break;
                            case 2:
                                // Зарегистрировать авиакомпанию
                                System.out.println("Авиакомпания зарегистрированна");
                                break;
                            case 3:
                                // Зарегестрировать самолет
                                System.out.println("Самолет зарегистрирован");
                                break;
                            case 0:
                                // Вернуться в предыдущее меню
                                isExit2 = true;
                                break;
                        }
                    }
                    break;
                case 2:
                    // Клиент
                    System.out.println("Вы работаете как пользователь.\n");

                    boolean isExit3 = false;

                    while (!isExit3) {
                        showSecondClientScreen();

                        switch (inputNumber()) {
                            case 1:
                                showAirlinesListScreen();
                                break;
                            case 0:
                                // Вернуться в предыдущее меню
                                isExit3 = true;
                                break;
                        }
                    }
                    break;
                case 0:
                    // Выход из системы
                    System.out.println(ConstantStrings.IS_EXIT);
                    isExit = true;
                    break;
                default:
                    System.out.println(ConstantStrings.MENU_DELIMITER);
                    System.out.println(ConstantStrings.WRONG_INPUT);
            }
        }
    }

    public static void showFirstScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        System.out.println(
                "Выберите пользователя:\n" +
                "1. Администратор\n" +
                "2. Клиент\n" +
                "0. Выход"
        );
        System.out.println(ConstantStrings.MENU_DELIMITER);
    }

    public static void showSecondAdminScreen() {
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

    public static void showSecondClientScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        System.out.println(ConstantStrings.SELECT_OPERATION);
        System.out.println(
                "1. Просмотреть список авиакомпаний." + "\n" +
                ConstantStrings.BACK
        );
        System.out.println(ConstantStrings.MENU_DELIMITER);
    }

    public static void showAirlinesListScreen() {
        System.out.println(ConstantStrings.MENU_DELIMITER);
        AirlineManagementTool.printAirlines();
        System.out.println("\n" + ConstantStrings.BACK);
        System.out.println(ConstantStrings.MENU_DELIMITER);
        while (true){
            if (inputNumber() == 0) {
                break;
            }
            System.out.println("Для возврата в предыдущее меню введите 0.");
        }
    }

    public static int inputNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = -1;

        while (inputNumber < 0) {
            try {
                inputNumber = Integer.parseInt(reader.readLine());

                if (inputNumber >= 0) {
                    return inputNumber;
                }
                else {
                    System.out.println(ConstantStrings.VALUE_MUST_BE_POSITIVE);
                }
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println(ConstantStrings.WRONG_INPUT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
