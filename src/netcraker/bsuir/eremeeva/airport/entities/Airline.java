package netcraker.bsuir.eremeeva.airport.entities;

import netcraker.bsuir.eremeeva.airport.entities.airplanes.Airplane;
import netcraker.bsuir.eremeeva.airport.tools.AirlineManagementTool;

import java.util.ArrayList;

public class Airline {
    private String name; // Название компании
    private int foundationYear; // Год основания
    private String codeICAO;
    private String address;
    private int totalCapacity = 0; // Общая вместимость (вместимость всех самолетов авиакомпании)
    private int totalCarryingCapacity = 0; // Общая грузоподъемность (всех самолетов авиакомпании)

    private ArrayList<Airplane> airplanes = new ArrayList<>(); // Список самолетов авиакомпании

    private Airline() {
    }

    public Airline(String name, int foundationYear, String codeICAO) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.codeICAO = codeICAO;
        this.address = "address not set";
    }

    public Airline(String name, int foundationYear, String codeICAO, String address) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.codeICAO = codeICAO;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getCodeICAO() {
        return codeICAO;
    }

    public void setCodeICAO(String codeICAO) {
        this.codeICAO = codeICAO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getTotalCarryingCapacity() {
        return totalCarryingCapacity;
    }

    public int getAirplanesCount() {
        return airplanes.size();
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public void setTotalCarryingCapacity(int totalCarryingCapacity) {
        this.totalCarryingCapacity = totalCarryingCapacity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        return foundationYear == airline.foundationYear
                && name.equals(airline.name)
                && codeICAO.equals(airline.codeICAO)
                && address.equals(airline.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + foundationYear;
        result = 31 * result + codeICAO.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Airline: " +
                name + " | " +
                "codeICAO='" + codeICAO +
                ", foundationYear = " + foundationYear +
                ", address='" + address;
    }
}
