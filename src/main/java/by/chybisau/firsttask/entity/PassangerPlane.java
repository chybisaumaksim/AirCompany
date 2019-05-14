package by.chybisau.firsttask.entity;

import java.util.Objects;

/**
 * Created by Maksim Chybisau on 02/05/19.
 *
 * @version 0.0.2
 */
public class PassangerPlane extends Plane {

    private double passangerCapacity;

    public PassangerPlane(long flyingMashineId, double flightRange, double cruisingSpeed,
                          double fuelConsumption, PlaneProducer producer,
                          String model, double passangerCapacity) {
        super(flyingMashineId, flightRange, cruisingSpeed, fuelConsumption, producer, model);
        this.passangerCapacity = passangerCapacity;
    }

    public PassangerPlane(double flightRange, double cruisingSpeed, double fuelConsumption,
                          PlaneProducer producer, String model, double passangerCapacity) {
        super(flightRange, cruisingSpeed, fuelConsumption, producer, model);
        this.passangerCapacity = passangerCapacity;
    }

    public PassangerPlane() {
    }

    public double getPassangerCapacity() {
        return passangerCapacity;
    }

    public void setPassangerCapacity(double passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassangerPlane that = (PassangerPlane) o;
        return Double.compare(that.passangerCapacity, passangerCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passangerCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PassangerPlane{");
        sb.append(super.toString());
        sb.append(", passangerCapacity=").append((int) passangerCapacity).append(" passangers");
        sb.append('}');
        return sb.toString();
    }
}
