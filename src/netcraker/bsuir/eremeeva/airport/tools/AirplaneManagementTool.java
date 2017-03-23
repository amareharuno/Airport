package netcraker.bsuir.eremeeva.airport.tools;

import netcraker.bsuir.eremeeva.airport.entities.Airplanes.AbstractAirplane;
import netcraker.bsuir.eremeeva.airport.entities.Employees.AbstractEmployee;

import java.util.ArrayList;

public class AirplaneManagementTool {

    public static void addEmployee(AbstractEmployee employee, AbstractAirplane airplane){
        ArrayList<AbstractEmployee> employees = airplane.getAirplaneEmployeeList();

        for (AbstractEmployee person : employees) {
            if (person.equals(employee)) {
                System.out.println("Этот сотрудник и так уже в составе персонала самолета.");
                return;
            }
        }
        employees.add(employee);
        airplane.setAirplaneEmployeeList(employees);
    }

    public static void removeEmployee(AbstractEmployee employee, AbstractAirplane airplane) {

        ArrayList<AbstractEmployee> employees = airplane.getAirplaneEmployeeList();

        if (employees.isEmpty()) {
            System.out.println("Персонал самолета еще не установлен.");
        }
        else {
            for (AbstractEmployee person : employees) {
                if (person.getId() == employee.getId()) {
                    employees.remove(employee);
                }
            }

            airplane.setAirplaneEmployeeList(employees);
        }
    }

    public static void printAirplaneStuff (AbstractAirplane airplane){
        ArrayList<AbstractEmployee> employees = airplane.getAirplaneEmployeeList();
        for (AbstractEmployee employee : employees) {
            System.out.println(employee);
        }
    }
}
