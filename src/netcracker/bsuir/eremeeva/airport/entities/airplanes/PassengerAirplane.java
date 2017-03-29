package netcracker.bsuir.eremeeva.airport.entities.airplanes;

import netcracker.bsuir.eremeeva.airport.enums.TypeOfService;

public class PassengerAirplane extends Airplane {
    private TypeOfService typeOfService;

    public PassengerAirplane(String name, int capacity, int carryingCapacity, int fuelConsumption,
                             int flightRange, int maxSpeed, TypeOfService typeOfService) {

        super(name, capacity, carryingCapacity, fuelConsumption, flightRange, maxSpeed);
        this.typeOfService = typeOfService;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }
}
