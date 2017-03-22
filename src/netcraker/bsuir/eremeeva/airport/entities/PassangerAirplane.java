package netcraker.bsuir.eremeeva.airport.entities;

import netcraker.bsuir.eremeeva.airport.enums.TypeOfService;

public class PassangerAirplane extends Airplane {
    private TypeOfService typeOfService;
    private int idPassAirplane;

    public PassangerAirplane(String name) {
        this.name = name;
        this.idPassAirplane = ++id;
    }

    public PassangerAirplane(String name, TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public PassangerAirplane(String name, int capacity, int carryingCapacity) {
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.idPassAirplane = ++id;
    }

    public PassangerAirplane (String name,
                              TypeOfService typeOfService,
                              int capacity,
                              int carryingCapacity,
                              int fuelConsumption,
                              int flightRange,
                              int maxSpeed) {
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.flightRange = flightRange;
        this.maxSpeed = maxSpeed;
        this.idPassAirplane = ++id;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    @Override
    public int getId() {
        return idPassAirplane;
    }
}
