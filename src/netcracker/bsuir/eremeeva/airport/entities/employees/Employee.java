package netcracker.bsuir.eremeeva.airport.entities.employees;

import netcracker.bsuir.eremeeva.airport.entities.airplanes.Airplane;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private static int incrementa = 0;
    private int id;
    private Airplane airplane; // Самолет, в котором работает сотрудник

    private Employee() {
    }

    protected Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = incrementa++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        return id == that.id && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return  "Employee" + id + ". " +
                firstName + ' ' +
                lastName + " - " +
                this.getClass();
    }
}
