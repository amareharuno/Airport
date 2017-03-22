package netcraker.bsuir.eremeeva.airport.entities;

import java.util.ArrayList;

public class Airline {
    private String name;
    private short foundationYear;
    private String codeICAO;
    private String address;

    private ArrayList<Airplane> airplanes = new ArrayList<>();
    private int totalCapacity = 0;
    private int totalCarryingCapacity = 0;

    private Airline() {
    }

    public Airline(String name, String codeICAO) {
        this.name = name;
        this.codeICAO = codeICAO;
    }

    public Airline(String name, String codeICAO, String address) {
        this.name = name;
        this.codeICAO = codeICAO;
        this.address = address;
    }

    public Airline(String name, short foundationYear, String codeICAO, String address) {
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

    public short getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(short foundationYear) {
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
        if (airplanes.isEmpty()) {
            System.out.println("В авиакомпании нет ни одного самолета.");
        }
        return totalCapacity;
    }

    public int getTotalCarryingCapacity() {
        if (airplanes.isEmpty()) {
            System.out.println("В авиакомпании нет ни одного самолета.");
        }
        return totalCarryingCapacity;
    }

    public int getAirplanesCount() {
        return airplanes.size();
    }

    public ArrayList<Airplane> getAirplanes() {
        if (airplanes.isEmpty()) {
            System.out.println("Внимание, в авиакомпании нет самолетов!");
        }
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
    public String toString() {
        return super.toString();
    }
}
