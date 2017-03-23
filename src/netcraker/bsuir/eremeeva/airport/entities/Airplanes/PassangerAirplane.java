package netcraker.bsuir.eremeeva.airport.entities.Airplanes;

import netcraker.bsuir.eremeeva.airport.Exceptions.IllegalValueException;
import netcraker.bsuir.eremeeva.airport.enums.TypeOfService;

public class PassangerAirplane extends AbstractAirplane {
    private TypeOfService typeOfService;

    public PassangerAirplane(String name,
                             int capacity,
                             int carryingCapacity,
                             int fuelConsumption,
                             int flightRange,
                             int maxSpeed,
                             TypeOfService typeOfService) throws IllegalValueException {

        super(name, capacity, carryingCapacity, fuelConsumption, flightRange, maxSpeed);
        this.typeOfService = typeOfService;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }
}
