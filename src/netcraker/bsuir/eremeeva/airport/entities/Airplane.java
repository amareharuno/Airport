package netcraker.bsuir.eremeeva.airport.entities;

import java.util.ArrayList;

public abstract class Airplane {
    protected static int id = 0;
    protected String name;

    protected int capacity;
    protected int carryingCapacity;
    protected int fuelConsumption;
    protected int flightRange;
    protected int maxSpeed;

    protected static ArrayList<Employee> employeeList = new ArrayList<>();

    protected Airplane() {
    }

    protected abstract int getId();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(ArrayList<Employee> employeeList) {
        Airplane.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
