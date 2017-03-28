package netcraker.bsuir.eremeeva.airport.tools;

public class ConstantStrings {
    public static final String NO_AIRPLANE_MESSAGE = "В компании нет ни одного самолета.";
    public static final String NO_AIRLINES_REGISTERED = "Нет зарегистрированных авиакомпаний";
    public static final String NO_EMPLOYEE_MESSAGE = "Персонал пока не установлен";
    public static final String NO_AIRPLANES_IN_THIS_RANGE = "Нет ни одного самолета в заданном диапазоне.";
    public static final String VALUE_MUST_BE_GREATER_THAN_ZERO = "Параметр должен быть больше 0.";
    public static final String EMPLOYEE_ON_BOARD = "Этот сотрудник уже в штате самолета.";
    public static final String MENU_DELIMITER = "========================================";

    // Menu
    public static final String VALUE_MUST_BE_POSITIVE = "Параметр не может быть отрицательным. Повторите ввод...";
    public static final String WRONG_INPUT = "Введен неверный параметр. Повторите ввод...";
    public static final String IS_EXIT = "Работа завершена. Хорошего дня :)";
    public static final String SELECT_OPERATION = "Выберите действие:";
    public static final String BACK = "0. Назад";

    // Regex
    public static final String SOME_WORDS_WITH_ONE_SPACE_REGEX = "\\s*(\\w+\\s??)+\\s*";
    public static final String WRONG_SOME_WORDS_INPUT_MESSAGE = "Строка пуста или введенные данные некорректны\n" +
            "(название должно сожержать одно или несколько слов, состоящих из цифр и/или букв," +
            " с одним пробелом между ними).\n";
}
