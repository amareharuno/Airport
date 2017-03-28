package netcraker.bsuir.eremeeva.airport.entities.airplanes;

import netcraker.bsuir.eremeeva.airport.entities.Airline;
import netcraker.bsuir.eremeeva.airport.entities.employees.Employee;

import java.util.ArrayList;

public abstract class Airplane {
    private static int id = 0; // Инекрементится при создании нового самолета
    private int idAirplane;
    private String name; // Название самолета

    private int capacity; // Вместимость
    private int carryingCapacity; // Грузоподъемность
    private int fuelConsumption; // Потребление топлива
    private int flightRange; // Дальность полета
    private int maxSpeed; // Максимальная скорость
    private Airline airline;

    private ArrayList<Employee> airplaneEmployeeList = new ArrayList<>(); // Персонал самолета

    protected Airplane() {
    }

    protected Airplane(String name, int capacity, int carryingCapacity,
                       int fuelConsumption, int flightRange, int maxSpeed) {
        this.idAirplane = id++;
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.flightRange = flightRange;
        this.maxSpeed = maxSpeed;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

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

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public ArrayList<Employee> getAirplaneEmployeeList() {
        return airplaneEmployeeList;
    }

    public void setAirplaneEmployeeList(ArrayList<Employee> airplaneEmployeeList) {
        this.airplaneEmployeeList = airplaneEmployeeList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airplane that = (Airplane) o;

        return idAirplane == that.idAirplane
                && capacity == that.capacity
                && carryingCapacity == that.carryingCapacity
                && fuelConsumption == that.fuelConsumption
                && flightRange == that.flightRange
                && maxSpeed == that.maxSpeed
                && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = idAirplane;
        result = 31 * result + name.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + carryingCapacity;
        result = 31 * result + fuelConsumption;
        result = 31 * result + flightRange;
        result = 31 * result + maxSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "Airplane " + name +
                "(id " + idAirplane +
                ") : capacity = " + capacity +
                ", carrying capacity = " + carryingCapacity +
                ", flight range = " + flightRange +
                ", fuel consumption = " + fuelConsumption;
    }
}