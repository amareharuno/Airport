package netcraker.bsuir.eremeeva.airport.entities.Airplanes;

import netcraker.bsuir.eremeeva.airport.Exceptions.IllegalValueException;

public class CargoAirplane extends AbstractAirplane {

    public CargoAirplane(String name,
                         int capacity,
                         int carryingCapacity,
                         int fuelConsumption,
                         int flightRange,
                         int maxSpeed) throws IllegalValueException {

        super(name, capacity, carryingCapacity, fuelConsumption, flightRange, maxSpeed);
    }
}