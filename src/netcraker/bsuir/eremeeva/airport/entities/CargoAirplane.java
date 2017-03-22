package netcraker.bsuir.eremeeva.airport.entities;

public class CargoAirplane extends Airplane {

    private int idCargo;

    public CargoAirplane(String name) {
        this.name = name;
        this.idCargo = ++id;
    }

    public CargoAirplane(String name, int capacity, int carryingCapacity) {
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.idCargo = ++id;
    }

    public CargoAirplane(String name, int capacity, int carryingCapacity, int fuelConsumption, int flightRange, int maxSpeed) {
        this.name = name;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.flightRange = flightRange;
        this.maxSpeed = maxSpeed;
        this.idCargo = ++id;
    }

    @Override
    public int getId() {
        return idCargo;
    }
}
