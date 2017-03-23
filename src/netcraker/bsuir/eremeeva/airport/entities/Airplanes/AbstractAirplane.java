package netcraker.bsuir.eremeeva.airport.entities.Airplanes;

import netcraker.bsuir.eremeeva.airport.Exceptions.IllegalValueException;
import netcraker.bsuir.eremeeva.airport.entities.Employees.AbstractEmployee;

import java.util.ArrayList;

public abstract class AbstractAirplane {
    private static int id = 0; // Инекрементится при создании нового самолета
    private int idAirplane;
    private String name; // Название самолета

    private int capacity; // Вместимость
    private int carryingCapacity; // Грузоподъемность
    private int fuelConsumption; // Потребление топлива
    private int flightRange; // Дальность полета
    private int maxSpeed; // Максимальная скорость

    private ArrayList<AbstractEmployee> airplaneEmployeeList = new ArrayList<>(); // Персонал самолета

    protected AbstractAirplane(String name,
                               int capacity,
                               int carryingCapacity,
                               int fuelConsumption,
                               int flightRange,
                               int maxSpeed) throws IllegalValueException {
        this.idAirplane = id++;

        this.name = name;

        if (capacity <= 0 || carryingCapacity <= 0 || fuelConsumption <= 0 || flightRange <= 0 || maxSpeed <= 0){
            throw new IllegalValueException(
                    "Параметры capacity, carryingCapacity, fuelConsumption, flightRange и maxSpeed должны быть >= 0" + "\n" +
                            "Неверные данные для самолета " + this.name + "\n" +
                            "Объект класса " + this.getClass().getName() + " не был создан.")
                            ;
        }
        else {
            this.capacity = capacity;
            this.carryingCapacity = carryingCapacity;
            this.fuelConsumption = fuelConsumption;
            this.flightRange = flightRange;
            this.maxSpeed = maxSpeed;
        }
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

    public void setCapacity(int capacity) throws IllegalValueException {
        if (capacity < 0) {
            throw new IllegalValueException("Параметр capacity не может быть меньше 0. Значение не установлено.");
        }
        else {
            this.capacity = capacity;
        }
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) throws IllegalValueException {
        if (carryingCapacity < 0) {
            throw new IllegalValueException("Параметр carryingCapacity не может быть меньше 0. Значение не установлено.");
        }
        else {
            this.carryingCapacity = carryingCapacity;
        }
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) throws IllegalValueException {
        if (fuelConsumption < 0) {
            throw new IllegalValueException("Параметр fuelConsumption не может быть меньше 0. Значение не установлено.");
        }
        else {
            this.fuelConsumption = fuelConsumption;
        }
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) throws IllegalValueException {
        if (flightRange < 0) {
            throw new IllegalValueException("Параметр flightRange не может быть меньше 0. Значение не установлено.");
        }
        else {
            this.flightRange = flightRange;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) throws IllegalValueException {
        if (maxSpeed < 0) {
            throw new IllegalValueException("Параметр maxSpeed не может быть меньше 0. Значение не установлено.");
        }
        else {
            this.maxSpeed = maxSpeed;
        }
    }

    public ArrayList<AbstractEmployee> getAirplaneEmployeeList() {
        return airplaneEmployeeList;
    }

    public void setAirplaneEmployeeList(ArrayList<AbstractEmployee> airplaneEmployeeList) {
        this.airplaneEmployeeList = airplaneEmployeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractAirplane that = (AbstractAirplane) o;

        if (idAirplane != that.idAirplane) return false;
        if (capacity != that.capacity) return false;
        if (carryingCapacity != that.carryingCapacity) return false;
        if (fuelConsumption != that.fuelConsumption) return false;
        if (flightRange != that.flightRange) return false;
        if (maxSpeed != that.maxSpeed) return false;
        return name.equals(that.name);
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
        return "Airplane" +  idAirplane +
                " " + name + ": capacity = " + capacity +
                ", carrying capacity = " + carryingCapacity +
                ", flight range = " + flightRange +
                ", fuel consumption = " + fuelConsumption;
    }
}