package netcraker.bsuir.eremeeva.airport.entities;

import netcraker.bsuir.eremeeva.airport.entities.Airplanes.AbstractAirplane;

import java.util.ArrayList;

public class Airline {
    private String name;
    private int foundationYear;
    private String codeICAO;
    private String address;
    private int totalCapacity = 0;
    private int totalCarryingCapacity = 0;

    private ArrayList<AbstractAirplane> airplanes = new ArrayList<>();

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

    public ArrayList<AbstractAirplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<AbstractAirplane> airplanes) {
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

        if (foundationYear != airline.foundationYear) return false;
        if (!name.equals(airline.name)) return false;
        if (!codeICAO.equals(airline.codeICAO)) return false;
        return address.equals(airline.address);
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
