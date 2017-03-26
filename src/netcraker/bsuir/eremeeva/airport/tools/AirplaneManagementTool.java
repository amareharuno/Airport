package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.airplanes.Airplane;
import netcraker.bsuir.eremeeva.airport.entities.employees.Employee;

import java.util.ArrayList;

public class AirplaneManagementTool {

    /**
     * Добавление сотрудников в персонал самолета.
     * @param employee - сотрудник
     * @param airplane - целевой самолет
     */
    public static void addEmployee(Employee employee, Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();

        for (Employee person : employees) {
            if (person.equals(employee)) {
                System.out.println(MessageStrings.EMPLOYEE_ON_BOARD);
                return;
            }
        }
        employees.add(employee);
        employee.setAirplane(airplane);
        airplane.setAirplaneEmployeeList(employees);
    }

    /**
     * Удаление сотрудника из персонала самолета
     * @param employee - сотрудник
     * @param airplane - целевой самолет
     */
    public static void removeEmployee(Employee employee, Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();

        if (employees.isEmpty()) {
            System.out.println(MessageStrings.NO_EMPLOYEE_MESSAGE);
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

    /**
     * Вывод списка сотрудников самолета
     * @param airplane - целевой самолет
     */
    public static void printAirplaneStuff (Airplane airplane) {

        ArrayList<Employee> employees = airplane.getAirplaneEmployeeList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
