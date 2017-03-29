package netcracker.bsuir.eremeeva.airport.tools.entitiesTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class InputVerification {

    // Принимает введенное из консоли число и проверяет на правильность (inputNumber >= 0)
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

    // Возвращает правильную строку (состоит из букв и цифр с разделением в 1 пробел)
    // preInputMessage - строка, обозначающая, что надо ввести
    public static String checkInputString(String preInputMessage) throws IOException {

        boolean isExit = false;
        String rightString = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isExit) {
            System.out.println(preInputMessage);
            String string = reader.readLine();

            boolean stringIsCorrect = false;

            while (!stringIsCorrect) {
                if (!string.matches(ConstantStrings.SOME_WORDS_WITH_ONE_SPACE_REGEX)) {
                    System.out.println(ConstantStrings.WRONG_SOME_WORDS_INPUT_MESSAGE);
                    System.out.println(preInputMessage);
                    string = reader.readLine();
                } else {
                    stringIsCorrect = true;
                    rightString = string.trim();
                    isExit = true;
                }
            }
        }
        return rightString;
    }

    public  static int checkInputYear() throws IOException {

        boolean isExit = false;
        int foundationYear = 0;

        while (!isExit) {
            System.out.println("Введите год основания (от 1903 до 2017): ");
            boolean yearIsCorrect = false;
            foundationYear = inputNumber();

            while (!yearIsCorrect) {
                if (foundationYear < 1903 || foundationYear > 2017) {
                    System.out.println("В 1903 г. братья Райт можно считать впервые поднялись в небо.\n" +
                            "Выберите год от 1903 до 2017.\nВведите год основания: ");
                    foundationYear = inputNumber();
                } else {
                    yearIsCorrect = true;
                    isExit = true;
                }
            }
        }
        return foundationYear;
    }

    public static int checkInputInt(String preInputMessage) throws IOException {

        while (true) {
            System.out.println(preInputMessage);
            int number = inputNumber();
            if (number > 0) {
                return number;
            }
        }
    }
}
