package by.chybisau.firsttask.entity;


import java.util.Objects;

/**
 * Created by Maksim Chybisau on 02/05/19.
 * @version 0.0.2
 */

public class CargoPlane extends Plane {

    private double cargoCapacity;

    public CargoPlane(long flyingMashineId, double flightRange, double cruisingSpeed, double fuelConsumption, PlaneProducer producer, String model, double cargoCapacity) {
        super(flyingMashineId, flightRange, cruisingSpeed, fuelConsumption, producer, model);
        this.cargoCapacity = cargoCapacity;
    }

    public CargoPlane(double flightRange, double cruisingSpeed, double fuelConsumption, PlaneProducer producer, String model, double cargoCapacity) {
        super(flightRange, cruisingSpeed, fuelConsumption, producer, model);
        this.cargoCapacity = cargoCapacity;
    }

    public CargoPlane() {
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return Double.compare(that.cargoCapacity, cargoCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CargoPlane{");
        sb.append(super.toString());
        sb.append(", cargoCapacity=").append(cargoCapacity).append(" tons");
        sb.append('}');
        return sb.toString();
    }
}

